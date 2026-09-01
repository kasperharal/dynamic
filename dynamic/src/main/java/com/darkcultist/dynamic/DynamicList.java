package com.darkcultist.dynamic;

import static com.darkcultist.dynamic.Dynamic.stringify;

import java.util.ArrayList;
import java.util.Iterator;


public class DynamicList implements Iterable<Object> {
    protected final ArrayList<Object> values;
    
    public DynamicList()  {
        values = new ArrayList<>();
    }

    
    public DynamicList(String src) throws DynamicExeption {
        values = new DynamicParser(src).getList().values;
    }

    
    public boolean isNull(int index) {
        return index >= 0 && index < values.size() && values.get(index) == null?true:false;
    }

    
    public Object opt(int index) {
        return index >= 0 && index < values.size()?values.get(index):null;
    }

    
    public Object opt(int index, Object defaultValue) {
        Object object = this.opt(index);
        return object == null?defaultValue:object;
    }

    
    public Object get(int index) throws DynamicExeption {
        Object object = this.opt(index);
        if (object == null) throw new DynamicExeption("list["+index+"] was not found");
        return object;
    }

    
    public boolean optBoolean(int index) {
        Object object = this.opt(index);
        return object instanceof Boolean b?b:null;
    }

    
    public boolean optBoolean(int index, boolean defaultValue) {
        Boolean b = this.optBoolean(index);
        return b == null?defaultValue:b;
    }

    
    public boolean getBoolean(int index) throws DynamicExeption {
        Object object = this.get(index);
        if (object instanceof Boolean b) return b;
        else throw new DynamicExeption("list["+index+"] was not found");
    }

    
    public byte optByte(int index) {
        return optNumber(index).byteValue();
    }

    
    public byte optByte(int index, byte defaultValue) {
        return optNumber(index, defaultValue).byteValue();
    }

    
    public byte getByte(int index) throws DynamicExeption {
        return getNumber(index).byteValue();
    }

    
    public short optShort(int index) {
        return optNumber(index).shortValue();
    }

    
    public short optShort(int index, short defaultValue) {
        return optNumber(index, defaultValue).shortValue();
    }

    
    public short getShort(int index) throws DynamicExeption {
        return getNumber(index).shortValue();
    }

    
    public int optInt(int index) {
        return optNumber(index).intValue();
    }

    
    public int optInt(int index, int defaultValue) {
        return optNumber(index, defaultValue).intValue();
    }

    
    public int getInt(int index) throws DynamicExeption {
        return getNumber(index).intValue();
    }

    
    public long optLong(int index) {
        return optNumber(index).longValue();
    }

    
    public long optLong(int index, long defaultValue) {
        return optNumber(index, defaultValue).longValue();
    }

    
    public long getLong(int index) throws DynamicExeption {
        return  getNumber(index).longValue();
    }

    
    public float optFloat(int index) {
        return optNumber(index).floatValue();
    }

    
    public float optFloat(int index, float defaultValue) {
        return optNumber(index, defaultValue).floatValue();
    }

    
    public float getFloat(int index) throws DynamicExeption {
        return getNumber(index).floatValue();
    }

    
    public double optDouble(int index) {
        return optNumber(index).doubleValue();
    }

    
    public double optDouble(int index, double defaultValue) {
        return optNumber(index, defaultValue).doubleValue();
    }

    
    public double getDouble(int index) throws DynamicExeption {
        return getNumber(index).doubleValue();
    }

    
    public Number optNumber(int index) {
        Object object = this.opt(index);
        return object instanceof Number num?num:null;
    }

    
    public Number optNumber(int index, Number defaultValue) {
        Number num = this.optNumber(index);
        return num == null?defaultValue:num;
    }

    
    public Number getNumber(int index) throws DynamicExeption {
        Object object = this.get(index);
        if (object instanceof Number num) return num;
        else throw new DynamicExeption("list["+index+"] was not found");
    }

    
    public String optString(int index) {
        Object object = this.opt(index);
        return object instanceof String str?str:null;
    }

    
    public String optString(int index, String defaultValue) {
        String str = this.optString(index);
        return str == null?defaultValue:str;
    }

    
    public String getString(int index) throws DynamicExeption {
        Object object = this.get(index);
        if (object instanceof String str) return str;
        else throw new DynamicExeption("list["+index+"] was not found");
    }

    
    public DynamicList optList(int index) {
        Object object = this.opt(index);
        return object instanceof DynamicList list?list:null;
    }

    
    public DynamicList optList(int index, DynamicList defaultValue) {
        DynamicList list = this.optList(index);
        return list == null?list:defaultValue;
    }

    
    public DynamicList getList(int index) throws DynamicExeption {
        Object object = this.get(index);
        if (object instanceof DynamicList list) return list;
        else throw new DynamicExeption("list["+index+"] was not found");
    }

    
    public DynamicObject optObj(int index) {
        Object object = this.opt(index);
        return object instanceof DynamicObject obj?obj:null;
    }

    
    public DynamicObject optObj(int index, DynamicObject defaultValue) {
        DynamicObject obj = this.optObj(index);
        return obj == null?defaultValue:obj;
    }

    
    public DynamicObject getObj(int index) throws DynamicExeption {
        Object object = this.get(index);
        if (object instanceof DynamicObject obj) return obj;
        else throw new DynamicExeption("list["+index+"] was not found");
    }

    
    public DynamicMap optMap(int index) {
        Object object = this.opt(index);
        return object instanceof DynamicMap map?map:null;
    }

    
    public DynamicMap optMap(int index, DynamicMap defaultValue) {
        DynamicMap map = this.optMap(index);
        return map == null?defaultValue:map;
    }

    
    public DynamicMap getMap(int index) throws DynamicExeption {
        Object object = this.get(index);
        if (object instanceof DynamicMap map) return map;
        else throw new DynamicExeption("list["+index+"] was not found");
    }

    
    public void set(int index, Object value) throws DynamicExeption {
        if (index < 0 && index >= values.size()) throw new DynamicExeption(index+" is out of bounds");
        values.set(index, value);
    }

    
    public void add(int index, Object value) throws DynamicExeption {
        if (index < 0 && index > values.size()) throw new DynamicExeption(index+" is out of bounds");
        values.add(index, value);
    }

    
    public void add(Object value) {
        values.add(value);
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

    
    public boolean contains(Object o) {
        return values.contains(o);
    }

    
    public int indexOf(Object o) {
        return values.indexOf(o);
    }

    
    public Object remove(int index) throws DynamicExeption {
        if (index < 0 && index >= values.size()) throw new DynamicExeption(index+" is out of bounds");
        return values.remove(index);
    }
    
    @Override
    public Iterator<Object> iterator() {
        return values.iterator();
    }

    @Override
    public String toString() {
        String out = "[";
        for (Object element : values) {
            out += (out.endsWith(" ") || out.endsWith("[")?"":" ")+stringify(element);
        }
        return out+"]";
    }
}
