package com.alphaomega;

import java.util.ArrayList;
import java.util.Iterator;
import static com.alphaomega.AlphaOmega.stringify;


public class GreekList implements Iterable<Object> {
    protected final ArrayList<Object> values;
    
    public GreekList()  {
        values = new ArrayList<>();
    }

    
    public GreekList(String src) throws AlphaOmegaExeption {
        values = new AlphaOmegaParser(src).getList().values;
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

    
    public Object get(int index) throws AlphaOmegaExeption {
        Object object = this.opt(index);
        if (object == null) throw new AlphaOmegaExeption("list["+index+"] was not found");
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

    
    public boolean getBoolean(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Boolean b) return b;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    
    public byte optByte(int index) {
        return optNumber(index).byteValue();
    }

    
    public byte optByte(int index, byte defaultValue) {
        return optNumber(index, defaultValue).byteValue();
    }

    
    public byte getByte(int index) throws AlphaOmegaExeption {
        return getNumber(index).byteValue();
    }

    
    public short optShort(int index) {
        return optNumber(index).shortValue();
    }

    
    public short optShort(int index, short defaultValue) {
        return optNumber(index, defaultValue).shortValue();
    }

    
    public short getShort(int index) throws AlphaOmegaExeption {
        return getNumber(index).shortValue();
    }

    
    public int optInt(int index) {
        return optNumber(index).intValue();
    }

    
    public int optInt(int index, int defaultValue) {
        return optNumber(index, defaultValue).intValue();
    }

    
    public int getInt(int index) throws AlphaOmegaExeption {
        return getNumber(index).intValue();
    }

    
    public long optLong(int index) {
        return optNumber(index).longValue();
    }

    
    public long optLong(int index, long defaultValue) {
        return optNumber(index, defaultValue).longValue();
    }

    
    public long getLong(int index) throws AlphaOmegaExeption {
        return  getNumber(index).longValue();
    }

    
    public float optFloat(int index) {
        return optNumber(index).floatValue();
    }

    
    public float optFloat(int index, float defaultValue) {
        return optNumber(index, defaultValue).floatValue();
    }

    
    public float getFloat(int index) throws AlphaOmegaExeption {
        return getNumber(index).floatValue();
    }

    
    public double optDouble(int index) {
        return optNumber(index).doubleValue();
    }

    
    public double optDouble(int index, double defaultValue) {
        return optNumber(index, defaultValue).doubleValue();
    }

    
    public double getDouble(int index) throws AlphaOmegaExeption {
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

    
    public Number getNumber(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Number num) return num;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    
    public String optString(int index) {
        Object object = this.opt(index);
        return object instanceof String str?str:null;
    }

    
    public String optString(int index, String defaultValue) {
        String str = this.optString(index);
        return str == null?defaultValue:str;
    }

    
    public String getString(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof String str) return str;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    
    public GreekList optList(int index) {
        Object object = this.opt(index);
        return object instanceof GreekList list?list:null;
    }

    
    public GreekList optList(int index, GreekList defaultValue) {
        GreekList list = this.optList(index);
        return list == null?list:defaultValue;
    }

    
    public GreekList getList(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof GreekList list) return list;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    
    public GreekSet optSet(int index) {
        Object object = this.opt(index);
        return object instanceof GreekSet set?set:null;
    }

    
    public GreekSet optSet(int index, GreekSet defaultValue) {
        GreekSet set = this.optSet(index);
        return set == null?defaultValue:set;
    }

    
    public GreekSet getSet(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof GreekSet set) return set;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    
    public GreekMap optMap(int index) {
        Object object = this.opt(index);
        return object instanceof GreekMap map?map:null;
    }

    
    public GreekMap optMap(int index, GreekMap defaultValue) {
        GreekMap map = this.optMap(index);
        return map == null?defaultValue:map;
    }

    
    public GreekMap getMap(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof GreekMap map) return map;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    
    public void set(int index, Object value) throws AlphaOmegaExeption {
        if (index < 0 && index >= values.size()) throw new AlphaOmegaExeption(index+" is out of bounds");
        values.set(index, value);
    }

    
    public void add(int index, Object value) throws AlphaOmegaExeption {
        if (index < 0 && index > values.size()) throw new AlphaOmegaExeption(index+" is out of bounds");
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

    
    public Object remove(int index) throws AlphaOmegaExeption {
        if (index < 0 && index >= values.size()) throw new AlphaOmegaExeption(index+" is out of bounds");
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
