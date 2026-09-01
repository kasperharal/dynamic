package com.darkcultist.dynamic;

import java.util.ArrayList;

public class DynamicParser {
    private final ArrayList<String> tokens = new ArrayList<>();
    private int i;
    public DynamicParser(String src) throws DynamicExeption {
        while (!src.isEmpty()) {
            String line = src.trim();
            line = detoken(line).trim();
            if (src.equals(line)) throw new DynamicExeption("unknown token error");
            src = line;
        }
    }

    private String detoken(String line) {
        String str = line;
        while (!str.isEmpty()) {
            if (str.matches("#.*")) {
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
            } else if (str.matches("-?\\d+(\\.\\d+)?")) {
                tokens.add(str);
                break;
            } else if (str.matches("\\d+%")) {
                tokens.add(""+Long.parseLong(str.substring(0, str.length()-1))/100d);
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
        if (i < 0 || i >= tokens.size()) return "";
        return tokens.get(i++);
    }

    public String peek() {
        if (i < 0 || i >= tokens.size()) return "";
        return tokens.get(i);
    }

    public boolean isValue() {
        String value = peek();
        if (value.matches("(true|false)")) return true;
        else if (value.matches("null")) return true;
        else if (value.matches("-?\\d+(\\.\\d+)?")) return true;
        else if (value.matches("(?s)[\\\"\\'](\\\\[\\\"\\']|[^\\\"\\'])*?[\\\"\\']")) return true;
        else if (value.matches("\\[")) return true;
        else if (value.matches("\\(")) return true;
        else if (value.matches("\\{")) return true;
        else return false;
    }

    public Object getValue() throws DynamicExeption {
        String value = peek();
        if (value.matches("(true|false)")) return getBoolean();
        else if (value.matches("null")) return getNull();
        else if (value.matches("-?\\d+(\\.\\d+)?")) return getNumber();
        else if (value.matches("(?s)[\\\"\\'](\\\\[\\\"\\']|[^\\\"\\'])*?[\\\"\\']")) return getString();
        else if (value.matches("\\[")) return getList();
        else if (value.matches("\\(")) return getObject();
        else if (value.matches("\\{")) return getMap();
        else throw new DynamicExeption("value syntax error");
    }


    public DynamicMap getMap() throws DynamicExeption {
        if (!next().equals("{")) throw new DynamicExeption("map syntax error");
        DynamicMap map = new DynamicMap();
        while (!peek().equals("}")) {
            String key = next();
            if (!key.matches("[a-zA-Z-_][a-zA-Z0-9-_]*:")) throw new DynamicExeption("map syntax error");
            Object value = getValue();
            map.add(key.substring(0, key.length()-1), value);
            if (peek().equals(",")) next();
        }
        return map;
    }


    public DynamicObject getObject() throws DynamicExeption {
        if (!next().equals("(")) throw new DynamicExeption("object syntax error");
        DynamicObject object = new DynamicObject();
        while (!peek().equals(")")) {
            if (isValue()) {
                object.add(getValue());
            } else {
                String key = next();
                if (!key.matches("[a-zA-Z-_][a-zA-Z0-9-_]*:")) throw new DynamicExeption("map syntax error");
                Object value = getValue();
                object.put(key.substring(0, key.length()-1), value);
            }
            
            if (peek().equals(",")) next();
        }
        return object;
    }

    public DynamicList getList() throws DynamicExeption {
        if (!next().equals("[")) throw new DynamicExeption("list syntax error");
        DynamicList list = new DynamicList();
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

    public Number getNumber() throws DynamicExeption {
        try {
            return Double.valueOf(next());
        } catch (NumberFormatException e) {
            throw new DynamicExeption("number syntax error");
        }
    }

    public boolean getBoolean() throws DynamicExeption {
        return switch (next()) {
            case "true" -> true;
            case "false" -> false;
            default -> throw new DynamicExeption("boolean syntax error");
        };
    }

    public Object getNull() throws DynamicExeption {
        if (next().equals("null")) return null;
        else throw new DynamicExeption("null syntax error");
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
