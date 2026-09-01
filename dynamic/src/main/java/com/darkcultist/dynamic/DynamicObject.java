package com.darkcultist.dynamic;

import static com.darkcultist.dynamic.Dynamic.stringify;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.awt.Color;


public class DynamicObject {
    private static HashMap<String, DynamicType> types = new HashMap<>();
    protected final HashMap<String, Object> values;

    static {
        putType(Color.class, new DynamicType(
            (o, dyn) -> {
                dyn.values.put("color", ((Color)o).getRGB());
            }, (dyn) -> {
                try {
                    if (dyn.values.get("red") instanceof Number red && dyn.values.get("green") instanceof Number green && dyn.values.get("blue") instanceof Number blue) {
                        if (dyn.values.get("alpha") instanceof Number alpha) return (Object)new Color(red.floatValue(), green.floatValue(), blue.floatValue(), alpha.floatValue());
                        return (Object)new Color(red.floatValue(), green.floatValue(), blue.floatValue());
                    } else if (dyn.values.get("color") instanceof Number color) {
                        return (Object)new Color(color.intValue());
                    } else if (dyn.values.get("") instanceof Number color) {
                        return (Object)new Color(color.intValue());
                    } else if (dyn.values.get("") instanceof DynamicList list) {
                        if (list.size() == 3) {
                            return (Object)new Color(list.getInt(0), list.getInt(1), list.getInt(2));
                        } else if (list.size() == 4) {
                            return (Object)new Color(list.getInt(0), list.getInt(1), list.getInt(2), list.getInt(3));
                        }
                    }
                    throw new DynamicExeption("DynamicObject is not a Color");
                } catch (DynamicExeption e) {
                    e.printStackTrace();
                    return null;
                }
            }));
    }

    public static <T> void putType(Class<T> clazz, DynamicType type) {
        types.put(clazz.getSimpleName(), type);
    }
    
    public DynamicObject()  {
        values = new HashMap<>();
        values.put("", new DynamicList());
    }

    
    public DynamicObject(String src) throws DynamicExeption {
        values = new DynamicParser(src).getObject().values;
    }

    public DynamicObject(Object obj) throws DynamicExeption  {
        values = new HashMap<>();
        String type = obj.getClass().getSimpleName();
        if (!types.containsKey(type)) throw new DynamicExeption("invalid type ("+type+") for DynamicObject");
        types.get(type).setter.accept(obj, this);
    }

    public Color getColor(String type) throws DynamicExeption  {
        if (values.get("red") instanceof Number red && values.get("green") instanceof Number green && values.get("blue") instanceof Number blue) {
            if (values.get("alpha") instanceof Number alpha) return new Color(red.floatValue(), green.floatValue(), blue.floatValue(), alpha.floatValue());
            return new Color(red.floatValue(), green.floatValue(), blue.floatValue());
        } else if (values.get("color") instanceof Number color) {
            return new Color(color.intValue());
        } else if (values.get("") instanceof Number color) {
            return new Color(color.intValue());
        } else if (values.get("") instanceof DynamicList list) {
            if (list.size() == 3) {
                return new Color(list.getInt(0), list.getInt(1), list.getInt(2));
            } else if (list.size() == 4) {
                return new Color(list.getInt(0), list.getInt(1), list.getInt(2), list.getInt(3));
            }
        }
        throw new DynamicExeption("DynamicObject is not a "+type);
    }

    public Object get(String type) throws DynamicExeption {
        if (!types.containsKey(type)) throw new DynamicExeption("invalid type ("+type+") for DynamicObject");
        return types.get(type).getter.apply(this);
    }

    public void put(String key, Object value) throws DynamicExeption {
        values.put(key, value);
    }

    
    public void add(Object value) throws DynamicExeption {
        ((DynamicList)values.get("")).add(value);
    }
    

    @Override
    public String toString() {
        String out = "(";
        for (Entry<String, Object> element : values.entrySet()) {
            out += (out.endsWith(" ") || out.endsWith("(")?"":" ")+(element.getKey().isEmpty()?"":element.getKey()+":")+stringify(element.getValue());
        }
        return out+")";
    }

    public static record DynamicType(BiConsumer<Object, DynamicObject> setter, Function<DynamicObject, Object> getter) {
    }
}
