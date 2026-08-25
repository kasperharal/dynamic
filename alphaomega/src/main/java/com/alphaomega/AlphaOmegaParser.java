package com.alphaomega;

import java.util.ArrayList;

public class AlphaOmegaParser {
    private final ArrayList<String> tokens = new ArrayList<>();
    private int i;
    public AlphaOmegaParser(String src) throws AlphaOmegaExeption {
        while (!src.isEmpty()) {
            String line = src.trim();
            line = detoken(line).trim();
            if (src.equals(line)) throw new AlphaOmegaExeption("unknown token error");
            src = line;
        }
    }

    private String detoken(String line) {
        String str = line;
        while (!str.isEmpty()) {
            if (str.matches("#.*")) {
                break;
            } else if (str.matches("(alpha|beta|gamma|delta|epsilon|zeta|eta|theta|iota|kappa|lambda|my|ny|xi|omikron|pi|rho|sigma|tau|ypsilon|fi|khi|psi|omega)")) {
                tokens.add(str);
                break;
            } else if (str.matches("(->|!)")) {
                tokens.add(str);
                break;
            } else if (str.matches("(true|false|null)")) {
                tokens.add(str);
                break;
            } else if (str.matches("-?[0-9a-fA-F]+[HhxX]")) {
                tokens.add(""+Long.parseLong(str.substring(0, str.length()-1), 16));
                break;
            } else if (str.matches("-?[0-7]+[oO]")) {
                tokens.add(""+Long.parseLong(str.substring(0, str.length()-1), 8));
                break;
            } else if (str.matches("-?[0-7]+[bB]")) {
                tokens.add(""+Long.parseLong(str.substring(0, str.length()-1), 2));
                break;
            } else if (str.matches("-?\\d+[fF]")) {
                tokens.add(str+".0");
                break;
            } else if (str.matches("-?\\d+(\\.\\d+)[fF]?")) {
                tokens.add(str.substring(0, str.length()-1));
                break;
            } else if (str.matches("-?\\d+")) {
                tokens.add(str);
                break;
            } else if (str.matches("(?s)[\\\"\\'](\\\\[\\\"\\']|[^\\\"\\'])*?[\\\"\\']")) {
                tokens.add(str.translateEscapes());
                break;
            } else if (str.matches("[\\[\\]\\(\\)\\{\\},]")) {
                tokens.add(str);
                break;
            } else if (str.matches("[a-zA-Z-_][a-zA-Z0-9-_]*:")) {
                tokens.add(str);
                break;
            }
            str = str.substring(0, str.length()-1);
        }
        return line.substring(str.length());
    }

    public String next() {
        if (i < 0 && i >= tokens.size()) return "";
        return tokens.get(i++);
    }

    public String peek() {
        if (i < 0 && i >= tokens.size()) return "";
        return tokens.get(i);
    }

    public Object getValue() throws AlphaOmegaExeption { // TODO add complex type parsing
        String value = peek();
        if (value.matches("(true|false)")) return getBoolean();
        else if (value.matches("null")) return getNull();
        else if (value.matches("-?\\d+")) return getInteger();
        else if (value.matches("-?\\d+(\\.\\d+)")) return getNumber();
        else if (value.matches("(?s)[\\\"\\'](\\\\[\\\"\\']|[^\\\"\\'])*?[\\\"\\']")) return getString();
        else if (value.matches("\\[")) return getList();
        else if (value.matches("!")) return getSet();
        else if (value.matches("\\(")) return getTable();
        else if (value.matches("\\{")) return getMap();
        else throw new AlphaOmegaExeption("value syntax error");
    }

    public GreekMap getMap() throws AlphaOmegaExeption {
        if (!next().equals("{")) throw new AlphaOmegaExeption("map syntax error");
        GreekMap map = new GreekMap();
        while (!peek().equals("}")) {
            String key = next();
            if (!key.matches("[a-zA-Z-_][a-zA-Z0-9-_]*:")) throw new AlphaOmegaExeption("map syntax error");
            map.add(key.substring(0, key.length()-1), getValue());
            if (peek().equals(",")) next();
        }
        return map;
    }

    public GreekTable getTable() throws AlphaOmegaExeption {
        if (!next().equals("(")) throw new AlphaOmegaExeption("table syntax error");
        GreekTable set = new GreekTable();
        while (!peek().equals(")")) {
            Object key = getValue();
            if (!next().matches("->")) throw new AlphaOmegaExeption("table syntax error");
            set.add(key, getValue());
            if (peek().equals(",")) next();
        }
        return set;
    }

    public GreekSet getSet() throws AlphaOmegaExeption {
        if (!next().equals("!")) throw new AlphaOmegaExeption("set syntax error");
        if (!next().equals("[")) throw new AlphaOmegaExeption("set syntax error");
        GreekSet set = new GreekSet();
        while (!peek().equals("]")) {
            set.add(getValue());
            if (peek().equals(",")) next();
        }
        return set;
    }

    public GreekList getList() throws AlphaOmegaExeption {
        if (!next().equals("[")) throw new AlphaOmegaExeption("list syntax error");
        GreekList list = new GreekList();
        while (!peek().equals("]")) {
            list.add(getValue());
            if (peek().equals(",")) next();
        }
        return list;
    }

    public String getString() {
        String value = next();
        return value.substring(1, value.length()-1);
    }

    public Number getNumber() throws AlphaOmegaExeption {
        try {
            return Double.valueOf(next());
        } catch (NumberFormatException e) {
            throw new AlphaOmegaExeption("number syntax error");
        }
    }

    public Number getInteger() throws AlphaOmegaExeption {
        try {
            return Long.valueOf(next());
        } catch (NumberFormatException e) {
            throw new AlphaOmegaExeption("integer syntax error");
        }
    }

    public boolean getBoolean() throws AlphaOmegaExeption {
        return switch (next()) {
            case "true" -> true;
            case "false" -> false;
            default -> throw new AlphaOmegaExeption("boolean syntax error");
        };
    }

    public Object getNull() throws AlphaOmegaExeption {
        if (next().equals("null")) return null;
        else throw new AlphaOmegaExeption("null syntax error");
    }

    @Override
    public String toString() {
        String out = "";
        for (String string : tokens) {
            out += string;
        }
        return out;
    }
}
