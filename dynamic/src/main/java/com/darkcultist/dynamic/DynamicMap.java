package com.darkcultist.dynamic;

import static com.darkcultist.dynamic.Dynamic.stringify;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Map.Entry;


public class DynamicMap implements Iterable<String> {
    protected final HashMap<String, Object> values;
    
    public DynamicMap()  {
        values = new HashMap<>();
    }

    
    public DynamicMap(String src) throws DynamicExeption {
        values = new DynamicParser(src).getMap().values;
    }

    
    public boolean isNull(String key) {
        return values.containsKey(key) && values.get(key) == null?true:false;
    }

    
    public Object opt(String key) {
        return values.containsKey(key)?values.get(key):null;
    }

    
    public Object opt(String key, Object defaultValue) {
        Object object = this.opt(key);
        return object == null?defaultValue:object;
    }

    
    public Object get(String key) throws DynamicExeption {
        Object object = this.opt(key);
        if (object == null) throw new DynamicExeption("list["+key+"] was not found");
        return object;
    }

    
    public boolean optBoolean(String key) {
        Object object = this.opt(key);
        return object instanceof Boolean b?b:null;
    }

    
    public boolean optBoolean(String key, boolean defaultValue) {
        Boolean b = this.optBoolean(key);
        return b == null?defaultValue:b;
    }

    
    public boolean getBoolean(String key) throws DynamicExeption {
        Object object = this.get(key);
        if (object instanceof Boolean b) return b;
        else throw new DynamicExeption("list["+key+"] was not found");
    }

    
    public byte optByte(String key) {
        return optNumber(key).byteValue();
    }

    
    public byte optByte(String key, byte defaultValue) {
        return optNumber(key, defaultValue).byteValue();
    }

    
    public byte getByte(String key) throws DynamicExeption {
        return getNumber(key).byteValue();
    }

    
    public short optShort(String key) {
        return optNumber(key).shortValue();
    }

    
    public short optShort(String key, short defaultValue) {
        return optNumber(key, defaultValue).shortValue();
    }

    
    public short getShort(String key) throws DynamicExeption {
        return getNumber(key).shortValue();
    }

    
    public int optInt(String key) {
        return optNumber(key).intValue();
    }

    
    public int optInt(String key, int defaultValue) {
        return optNumber(key, defaultValue).intValue();
    }

    
    public int getInt(String key) throws DynamicExeption {
        return getNumber(key).intValue();
    }

    
    public long optLong(String key) {
        return optNumber(key).longValue();
    }

    
    public long optLong(String key, long defaultValue) {
        return optNumber(key, defaultValue).longValue();
    }

    
    public long getLong(String key) throws DynamicExeption {
        return  getNumber(key).longValue();
    }

    
    public float optFloat(String key) {
        return optNumber(key).floatValue();
    }

    
    public float optFloat(String key, float defaultValue) {
        return optNumber(key, defaultValue).floatValue();
    }

    
    public float getFloat(String key) throws DynamicExeption {
        return getNumber(key).floatValue();
    }

    
    public double optDouble(String key) {
        return optNumber(key).doubleValue();
    }

    
    public double optDouble(String key, double defaultValue) {
        return optNumber(key, defaultValue).doubleValue();
    }

    
    public double getDouble(String key) throws DynamicExeption {
        return getNumber(key).doubleValue();
    }

    
    public Number optNumber(String key) {
        Object object = this.opt(key);
        return object instanceof Number num?num:null;
    }

    
    public Number optNumber(String key, Number defaultValue) {
        Number num = this.optNumber(key);
        return num == null?defaultValue:num;
    }

    
    public Number getNumber(String key) throws DynamicExeption {
        Object object = this.get(key);
        if (object instanceof Number num) return num;
        else throw new DynamicExeption("list["+key+"] was not found");
    }

    
    public String optString(String key) {
        Object object = this.opt(key);
        return object instanceof String str?str:null;
    }

    
    public String optString(String key, String defaultValue) {
        String str = this.optString(key);
        return str == null?defaultValue:str;
    }

    
    public String getString(String key) throws DynamicExeption {
        Object object = this.get(key);
        if (object instanceof String str) return str;
        else throw new DynamicExeption("list["+key+"] was not found");
    }

    
    public DynamicList optList(String key) {
        Object object = this.opt(key);
        return object instanceof DynamicList list?list:null;
    }

    
    public DynamicList optList(String key, DynamicList defaultValue) {
        DynamicList list = this.optList(key);
        return list == null?list:defaultValue;
    }

    
    public DynamicList getList(String key) throws DynamicExeption {
        Object object = this.get(key);
        if (object instanceof DynamicList list) return list;
        else throw new DynamicExeption("list["+key+"] was not found");
    }

    
    public DynamicObject optObj(String key) {
        Object object = this.opt(key);
        return object instanceof DynamicObject obj?obj:null;
    }

    
    public DynamicObject optObj(String key, DynamicObject defaultValue) {
        DynamicObject obj = this.optObj(key);
        return obj == null?defaultValue:obj;
    }

    
    public DynamicObject getObj(String key) throws DynamicExeption {
        Object object = this.get(key);
        if (object instanceof DynamicObject obj) return obj;
        else throw new DynamicExeption("list["+key+"] was not found");
    }

    
    public DynamicMap optMap(String key) {
        Object object = this.opt(key);
        return object instanceof DynamicMap map?map:null;
    }

    
    public DynamicMap optMap(String key, DynamicMap defaultValue) {
        DynamicMap map = this.optMap(key);
        return map == null?defaultValue:map;
    }

    
    public DynamicMap getMap(String key) throws DynamicExeption {
        Object object = this.get(key);
        if (object instanceof DynamicMap map) return map;
        else throw new DynamicExeption("list["+key+"] was not found");
    }

    
    public void set(String key, Object value) throws DynamicExeption {
        if (!values.containsKey(key)) throw new DynamicExeption(key+" does not exist");
        values.put(key, value);
    }

    
    public void add(String key, Object value) throws DynamicExeption {
        if (values.containsKey(key)) throw new DynamicExeption(key+" already exists");
        values.put(key, value);
    }

    
    public int size() {
        return values.size();
    }

    
    public void clear() {
        values.clear();
    }

    
    public boolean isEmpty() {
        return values.isEmpty();
    }

    
    public boolean contains(String key) {
        return values.containsKey(key);
    }

    
    public String keyOf(Object o) {
        for (Entry<String, Object> entry : values.entrySet()) {
            if (Objects.equals(entry.getValue(), o)) return entry.getKey();
        }
        return null;
    }

    
    public Object remove(String key) throws DynamicExeption {
        return values.remove(key);
    }
    
    @Override
    public Iterator<String> iterator() {
        return values.keySet().iterator();
    }

    @Override
    public String toString() {
        String out = "{";
        for (Entry<String, Object> element : values.entrySet()) {
            out += (out.endsWith(" ") || out.endsWith("{")?"":" ")+element.getKey()+":"+stringify(element.getValue());
        }
        return out+"}";
    }
}
