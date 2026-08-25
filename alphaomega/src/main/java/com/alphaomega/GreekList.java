package com.alphaomega;

import java.util.ArrayList;
import java.util.Iterator;
import static com.alphaomega.AlphaOmega.stringify;


public class GreekList implements Iterable<Object> {
    protected final ArrayList<Object> values;

    /**
     * creates a new GreekList
     */
    public GreekList()  {
        values = new ArrayList<>();
    }

    /**
     * creates a new AlphaOmegaParser and gets a list from it
     */
    public GreekList(String src) throws AlphaOmegaExeption {
        values = new AlphaOmegaParser(src).getList().values;
    }

    /**
     * checks if value is null
     * @param index
     * @return returns true if index is within bounds and <code>list[index] == null</code> otherwise it returns false
     */
    public boolean isNull(int index) {
        return index >= 0 && index < values.size() && values.get(index) == null?true:false;
    }

    /**
     * gets value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent otherwise it returns <code>null</code>
     */
    public Object opt(int index) {
        return index >= 0 && index < values.size()?values.get(index):null;
    }

    /**
     * gets value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent otherwise it returns <code>defaultValue</code>
     */
    public Object opt(int index, Object defaultValue) {
        Object object = this.opt(index);
        return object == null?defaultValue:object;
    }

    /**
     * gets value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent
     */
    public Object get(int index) throws AlphaOmegaExeption {
        Object object = this.opt(index);
        if (object == null) throw new AlphaOmegaExeption("list["+index+"] was not found");
        return object;
    }

    /**
     * gets boolean value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is boolean otherwise it returns <code>null</code>
     */
    public boolean optBoolean(int index) {
        Object object = this.opt(index);
        return object instanceof Boolean b?b:null;
    }

    /**
     * gets boolean value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is boolean otherwise it returns <code>defaultValue</code>
     */
    public boolean optBoolean(int index, boolean defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Boolean b?b:defaultValue;
    }

    /**
     * gets boolean value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a boolean
     */
    public boolean getBoolean(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Boolean b) return b;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets byte value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is byte otherwise it returns <code>null</code>
     */
    public byte optByte(int index) {
        Object object = this.opt(index);
        return object instanceof Number num?num.byteValue():null;
    }

    /**
     * gets byte value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is byte otherwise it returns <code>defaultValue</code>
     */
    public byte optByte(int index, byte defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Number num?num.byteValue():defaultValue;
    }

    /**
     * gets byte value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a byte
     */
    public byte getByte(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Number num) return num.byteValue();
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets short value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is short otherwise it returns <code>null</code>
     */
    public short optShort(int index) {
        Object object = this.opt(index);
        return object instanceof Number num?num.shortValue():null;
    }

    /**
     * gets short value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is short otherwise it returns <code>defaultValue</code>
     */
    public short optShort(int index, short defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Number num?num.shortValue():defaultValue;
    }

    /**
     * gets short value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a short
     */
    public short getShort(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Number num) return num.shortValue();
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets int value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is int otherwise it returns <code>null</code>
     */
    public int optInt(int index) {
        Object object = this.opt(index);
        return object instanceof Number num?num.intValue():null;
    }

    /**
     * gets int value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is int otherwise it returns <code>defaultValue</code>
     */
    public int optInt(int index, int defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Number num?num.intValue():defaultValue;
    }

    /**
     * gets int value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a int
     */
    public int getInt(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Number num) return num.intValue();
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets long value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is long otherwise it returns <code>null</code>
     */
    public long optLong(int index) {
        Object object = this.opt(index);
        return object instanceof Number num?num.longValue():null;
    }

    /**
     * gets long value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is long otherwise it returns <code>defaultValue</code>
     */
    public long optLong(int index, long defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Number num?num.longValue():defaultValue;
    }

    /**
     * gets long value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a long
     */
    public long getLong(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Number num) return num.longValue();
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets float value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is float otherwise it returns <code>null</code>
     */
    public float optFloat(int index) {
        Object object = this.opt(index);
        return object instanceof Number num?num.floatValue():null;
    }

    /**
     * gets float value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is float otherwise it returns <code>defaultValue</code>
     */
    public float optFloat(int index, float defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Number num?num.floatValue():defaultValue;
    }

    /**
     * gets float value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a float
     */
    public float getFloat(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Number num) return num.floatValue();
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets double value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is double otherwise it returns <code>null</code>
     */
    public double optDouble(int index) {
        Object object = this.opt(index);
        return object instanceof Number num?num.doubleValue():null;
    }

    /**
     * gets double value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is double otherwise it returns <code>defaultValue</code>
     */
    public double optDouble(int index, double defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Number num?num.doubleValue():defaultValue;
    }

    /**
     * gets double value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a double
     */
    public double getDouble(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Number num) return num.doubleValue();
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets number value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is number otherwise it returns <code>null</code>
     */
    public Number optNumber(int index) {
        Object object = this.opt(index);
        return object instanceof Number num?num:null;
    }

    /**
     * gets number value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is number otherwise it returns <code>defaultValue</code>
     */
    public Number optNumber(int index, Number defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Number num?num:defaultValue;
    }

    /**
     * gets number value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a number
     */
    public Number getNumber(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Number num) return num;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets string value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is string otherwise it returns <code>null</code>
     */
    public String optString(int index) {
        Object object = this.opt(index);
        return object instanceof String str?str:null;
    }

    /**
     * gets string value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is string otherwise it returns <code>defaultValue</code>
     */
    public String optString(int index, String defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof String str?str:defaultValue;
    }

    /**
     * gets string value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a string
     */
    public String getString(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof String str) return str;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets list value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is list otherwise it returns <code>null</code>
     */
    public GreekList optList(int index) {
        Object object = this.opt(index);
        return object instanceof GreekList list?list:null;
    }

    /**
     * gets list value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is list otherwise it returns <code>defaultValue</code>
     */
    public GreekList optList(int index, GreekList defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof GreekList list?list:defaultValue;
    }

    /**
     * gets list value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a list
     */
    public GreekList getList(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof GreekList list) return list;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets table value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is table otherwise it returns <code>null</code>
     */
    public GreekTable optTable(int index) {
        Object object = this.opt(index);
        return object instanceof GreekTable table?table:null;
    }

    /**
     * gets table value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is table otherwise it returns <code>defaultValue</code>
     */
    public GreekTable optTable(int index, GreekTable defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof GreekTable table?table:defaultValue;
    }

    /**
     * gets table value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a table
     */
    public GreekTable getTable(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof GreekTable table) return table;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets map value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is map otherwise it returns <code>null</code>
     */
    public GreekMap optMap(int index) {
        Object object = this.opt(index);
        return object instanceof GreekMap map?map:null;
    }

    /**
     * gets map value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is map otherwise it returns <code>defaultValue</code>
     */
    public GreekMap optMap(int index, GreekMap defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof GreekMap map?map:defaultValue;
    }

    /**
     * gets map value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a map
     */
    public GreekMap getMap(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof GreekMap map) return map;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * sets a value of the list
     * @param index
     * @param value <code>list[index] = value</code>
     * @throws AlphaOmegaExeption if index is out of bounds
     */
    public void set(int index, Object value) throws AlphaOmegaExeption {
        if (index < 0 && index >= values.size()) throw new AlphaOmegaExeption(index+" is out of bounds");
        values.set(index, value);
    }

    /**
     * adds a value to the list
     * @param index
     * @param value <code>list[index] += value</code>
     * @throws AlphaOmegaExeption if index is out of bounds
     */
    public void add(int index, Object value) throws AlphaOmegaExeption {
        if (index < 0 && index > values.size()) throw new AlphaOmegaExeption(index+" is out of bounds");
        values.add(index, value);
    }

    /**
     * adds a value to the list
     * @param value <code>list += value</code>
     */
    public void add(Object value) {
        values.add(value);
    }

    /**
     * @return returns size of list
     */
    public int size() {
        return values.size();
    }

    /**
     * clears the list
     */
    public void clear() {
        values.clear();
    }

    /**
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * @param index
     * @return returns true if <code>list[index]</code> is pressent
     */
    public boolean contains(int i) {
        return opt(i) != null;
    }

    /**
     * @param o
     * @return returns the index of the first occurrence of <code>o</code> if pressent otherwise it returns -1
     */
    public int indexOf(Object o) {
        return values.indexOf(o);
    }

    /**
     * removes the value at <code>index</code>
     * @param index
     * @return returns the value that was removed
     * @throws AlphaOmegaExeption if index is out of bounds
     */
    public Object remove(int index) throws AlphaOmegaExeption {
        if (index < 0 && index >= values.size()) throw new AlphaOmegaExeption(index+" is out of bounds");
        return values.remove(index);
    }

    /**
     * removes the first occurrence of <code>o</code>
     * @param index
     * @return returns true if a value was removed
     */
    public boolean remove(Object o) {
        return values.remove(o);
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
