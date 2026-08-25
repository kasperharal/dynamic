package com.alphaomega;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import static com.alphaomega.AlphaOmega.stringify;


public class GreekTable implements Iterable<Object> {
    protected final HashMap<Object, Object> values;

    /**
     * creates a new GreekTable
     */
    public GreekTable()  {
        values = new HashMap<>();
    }

    /**
     * creates a new AlphaOmegaParser and gets a table from it
     */
    public GreekTable(String src) throws AlphaOmegaExeption {
        values = new AlphaOmegaParser(src).getTable().values;
    }

    /**
     * checks if value is null
     * @param key
     * @return returns true if key is pressent and <code>table[key] == null</code> otherwise it returns false
     */
    public boolean isNull(Object key) {
        return values.containsKey(key) && values.get(key) == null?true:false;
    }

    /**
     * gets value or null
     * @param key
     * @return returns <code>table[key]</code> if pressent otherwise it returns <code>null</code>
     */
    public Object opt(Object key) {
        return values.get(key);
    }

    /**
     * gets value or default
     * @param key
     * @param defaultValue
     * @return returns <code>table[key]</code> if pressent otherwise it returns <code>defaultValue</code>
     */
    public Object opt(Object key, Object defaultValue) {
        Object object = this.opt(key);
        return object == null?defaultValue:object;
    }

    /**
     * gets value
     * @param key
     * @return returns <code>table[key]</code>
     * @throws AlphaOmegaExeption if value is not pressent
     */
    public Object get(Object key) throws AlphaOmegaExeption {
        Object object = this.opt(key);
        if (object == null) throw new AlphaOmegaExeption("table["+key+"] was not found");
        return object;
    }

    /**
     * gets boolean value or null
     * @param key
     * @return returns <code>table[key]</code> if pressent and is boolean otherwise it returns <code>null</code>
     */
    public boolean optBoolean(Object key) {
        Object object = this.opt(key);
        return object instanceof Boolean b?b:null;
    }

    /**
     * gets boolean value or default
     * @param key
     * @param defaultValue
     * @return returns <code>table[key]</code> if pressent and is boolean otherwise it returns <code>defaultValue</code>
     */
    public boolean optBoolean(Object key, boolean defaultValue) {
        Object object = this.opt(key, defaultValue);
        return object instanceof Boolean b?b:defaultValue;
    }

    /**
     * gets boolean value
     * @param key
     * @return returns <code>table[key]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a boolean
     */
    public boolean getBoolean(Object key) throws AlphaOmegaExeption {
        Object object = this.get(key);
        if (object instanceof Boolean b) return b;
        else throw new AlphaOmegaExeption("table["+key+"] was not found");
    }

    /**
     * gets byte value or null
     * @param key
     * @return returns <code>table[key]</code> if pressent and is byte otherwise it returns <code>null</code>
     */
    public byte optByte(Object key) {
        Object object = this.opt(key);
        return object instanceof Number num?num.byteValue():null;
    }

    /**
     * gets byte value or default
     * @param key
     * @param defaultValue
     * @return returns <code>table[key]</code> if pressent and is byte otherwise it returns <code>defaultValue</code>
     */
    public byte optByte(Object key, byte defaultValue) {
        Object object = this.opt(key, defaultValue);
        return object instanceof Number num?num.byteValue():defaultValue;
    }

    /**
     * gets byte value
     * @param key
     * @return returns <code>table[key]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a byte
     */
    public byte getByte(Object key) throws AlphaOmegaExeption {
        Object object = this.get(key);
        if (object instanceof Number num) return num.byteValue();
        else throw new AlphaOmegaExeption("table["+key+"] was not found");
    }

    /**
     * gets short value or null
     * @param key
     * @return returns <code>table[key]</code> if pressent and is short otherwise it returns <code>null</code>
     */
    public short optShort(Object key) {
        Object object = this.opt(key);
        return object instanceof Number num?num.shortValue():null;
    }

    /**
     * gets short value or default
     * @param key
     * @param defaultValue
     * @return returns <code>table[key]</code> if pressent and is short otherwise it returns <code>defaultValue</code>
     */
    public short optShort(Object key, short defaultValue) {
        Object object = this.opt(key, defaultValue);
        return object instanceof Number num?num.shortValue():defaultValue;
    }

    /**
     * gets short value
     * @param key
     * @return returns <code>table[key]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a short
     */
    public short getShort(Object key) throws AlphaOmegaExeption {
        Object object = this.get(key);
        if (object instanceof Number num) return num.shortValue();
        else throw new AlphaOmegaExeption("table["+key+"] was not found");
    }

    /**
     * gets int value or null
     * @param key
     * @return returns <code>table[key]</code> if pressent and is int otherwise it returns <code>null</code>
     */
    public int optInt(Object key) {
        Object object = this.opt(key);
        return object instanceof Number num?num.intValue():null;
    }

    /**
     * gets int value or default
     * @param key
     * @param defaultValue
     * @return returns <code>table[key]</code> if pressent and is int otherwise it returns <code>defaultValue</code>
     */
    public int optInt(Object key, int defaultValue) {
        Object object = this.opt(key, defaultValue);
        return object instanceof Number num?num.intValue():defaultValue;
    }

    /**
     * gets int value
     * @param key
     * @return returns <code>table[key]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a int
     */
    public int getInt(Object key) throws AlphaOmegaExeption {
        Object object = this.get(key);
        if (object instanceof Number num) return num.intValue();
        else throw new AlphaOmegaExeption("table["+key+"] was not found");
    }

    /**
     * gets long value or null
     * @param key
     * @return returns <code>table[key]</code> if pressent and is long otherwise it returns <code>null</code>
     */
    public long optLong(Object key) {
        Object object = this.opt(key);
        return object instanceof Number num?num.longValue():null;
    }

    /**
     * gets long value or default
     * @param key
     * @param defaultValue
     * @return returns <code>table[key]</code> if pressent and is long otherwise it returns <code>defaultValue</code>
     */
    public long optLong(Object key, long defaultValue) {
        Object object = this.opt(key, defaultValue);
        return object instanceof Number num?num.longValue():defaultValue;
    }

    /**
     * gets long value
     * @param key
     * @return returns <code>table[key]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a long
     */
    public long getLong(Object key) throws AlphaOmegaExeption {
        Object object = this.get(key);
        if (object instanceof Number num) return num.longValue();
        else throw new AlphaOmegaExeption("table["+key+"] was not found");
    }

    /**
     * gets float value or null
     * @param key
     * @return returns <code>table[key]</code> if pressent and is float otherwise it returns <code>null</code>
     */
    public float optFloat(Object key) {
        Object object = this.opt(key);
        return object instanceof Number num?num.floatValue():null;
    }

    /**
     * gets float value or default
     * @param key
     * @param defaultValue
     * @return returns <code>table[key]</code> if pressent and is float otherwise it returns <code>defaultValue</code>
     */
    public float optFloat(Object key, float defaultValue) {
        Object object = this.opt(key, defaultValue);
        return object instanceof Number num?num.floatValue():defaultValue;
    }

    /**
     * gets float value
     * @param key
     * @return returns <code>table[key]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a float
     */
    public float getFloat(Object key) throws AlphaOmegaExeption {
        Object object = this.get(key);
        if (object instanceof Number num) return num.floatValue();
        else throw new AlphaOmegaExeption("table["+key+"] was not found");
    }

    /**
     * gets double value or null
     * @param key
     * @return returns <code>table[key]</code> if pressent and is double otherwise it returns <code>null</code>
     */
    public double optDouble(Object key) {
        Object object = this.opt(key);
        return object instanceof Number num?num.doubleValue():null;
    }

    /**
     * gets double value or default
     * @param key
     * @param defaultValue
     * @return returns <code>table[key]</code> if pressent and is double otherwise it returns <code>defaultValue</code>
     */
    public double optDouble(Object key, double defaultValue) {
        Object object = this.opt(key, defaultValue);
        return object instanceof Number num?num.doubleValue():defaultValue;
    }

    /**
     * gets double value
     * @param key
     * @return returns <code>table[key]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a double
     */
    public double getDouble(Object key) throws AlphaOmegaExeption {
        Object object = this.get(key);
        if (object instanceof Number num) return num.doubleValue();
        else throw new AlphaOmegaExeption("table["+key+"] was not found");
    }

    /**
     * gets number value or null
     * @param key
     * @return returns <code>table[key]</code> if pressent and is number otherwise it returns <code>null</code>
     */
    public Number optNumber(Object key) {
        Object object = this.opt(key);
        return object instanceof Number num?num:null;
    }

    /**
     * gets number value or default
     * @param key
     * @param defaultValue
     * @return returns <code>table[key]</code> if pressent and is number otherwise it returns <code>defaultValue</code>
     */
    public Number optNumber(Object key, Number defaultValue) {
        Object object = this.opt(key, defaultValue);
        return object instanceof Number num?num:defaultValue;
    }

    /**
     * gets number value
     * @param key
     * @return returns <code>table[key]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a number
     */
    public Number getNumber(Object key) throws AlphaOmegaExeption {
        Object object = this.get(key);
        if (object instanceof Number num) return num;
        else throw new AlphaOmegaExeption("table["+key+"] was not found");
    }

    /**
     * gets string value or null
     * @param index
     * @return returns <code>table[index]</code> if pressent and is string otherwise it returns <code>null</code>
     */
    public String optString(Object key) {
        Object object = this.opt(key);
        return object instanceof String str?str:null;
    }

    /**
     * gets string value or default
     * @param index
     * @param defaultValue
     * @return returns <code>table[index]</code> if pressent and is string otherwise it returns <code>defaultValue</code>
     */
    public String optString(Object key, String defaultValue) {
        Object object = this.opt(key, defaultValue);
        return object instanceof String str?str:defaultValue;
    }

    /**
     * gets string value
     * @param index
     * @return returns <code>table[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a string
     */
    public String getString(Object key) throws AlphaOmegaExeption {
        Object object = this.get(key);
        if (object instanceof String str) return str;
        else throw new AlphaOmegaExeption("table["+key+"] was not found");
    }

    /**
     * gets map value or null
     * @param key
     * @return returns <code>table[key]</code> if pressent and is list otherwise it returns <code>null</code>
     */
    public GreekList optList(Object key) {
        Object object = this.opt(key);
        return object instanceof GreekList list?list:null;
    }

    /**
     * gets map value or default
     * @param key
     * @param defaultValue
     * @return returns <code>table[key]</code> if pressent and is list otherwise it returns <code>defaultValue</code>
     */
    public GreekList optList(Object key, GreekList defaultValue) {
        Object object = this.opt(key, defaultValue);
        return object instanceof GreekList list?list:defaultValue;
    }

    /**
     * gets map value
     * @param key
     * @return returns <code>table[key]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a list
     */
    public GreekList getList(Object key) throws AlphaOmegaExeption {
        Object object = this.get(key);
        if (object instanceof GreekList list) return list;
        else throw new AlphaOmegaExeption("table["+key+"] was not found");
    }

    /**
     * gets table value or null
     * @param key
     * @return returns <code>table[key]</code> if pressent and is table otherwise it returns <code>null</code>
     */
    public GreekTable optTable(Object key) {
        Object object = this.opt(key);
        return object instanceof GreekTable table?table:null;
    }

    /**
     * gets table value or default
     * @param key
     * @param defaultValue
     * @return returns <code>table[key]</code> if pressent and is table otherwise it returns <code>defaultValue</code>
     */
    public GreekTable optTable(Object key, GreekTable defaultValue) {
        Object object = this.opt(key, defaultValue);
        return object instanceof GreekTable table?table:defaultValue;
    }

    /**
     * gets table value
     * @param key
     * @return returns <code>table[key]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a table
     */
    public GreekTable getTable(Object key) throws AlphaOmegaExeption {
        Object object = this.get(key);
        if (object instanceof GreekTable table) return table;
        else throw new AlphaOmegaExeption("table["+key+"] was not found");
    }

    /**
     * gets map value or null
     * @param key
     * @return returns <code>table[key]</code> if pressent and is map otherwise it returns <code>null</code>
     */
    public GreekMap optMap(Object key) {
        Object object = this.opt(key);
        return object instanceof GreekMap map?map:null;
    }

    /**
     * gets map value or default
     * @param key
     * @param defaultValue
     * @return returns <code>table[key]</code> if pressent and is map otherwise it returns <code>defaultValue</code>
     */
    public GreekMap optMap(Object key, GreekMap defaultValue) {
        Object object = this.opt(key, defaultValue);
        return object instanceof GreekMap map?map:defaultValue;
    }

    /**
     * gets map value
     * @param key
     * @return returns <code>table[key]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a map
     */
    public GreekMap getMap(Object key) throws AlphaOmegaExeption {
        Object object = this.get(key);
        if (object instanceof GreekMap map) return map;
        else throw new AlphaOmegaExeption("map["+key+"] was not found");
    }

    /**
     * make a table key refer to a value
     * @param key
     * @param value <code>table[key] = value</code>
     * @throws AlphaOmegaExeption if key does not exist
     */
    public void set(Object key, Object value) throws AlphaOmegaExeption {
        if (!values.containsKey(key)) throw new AlphaOmegaExeption("table does not contain "+value);
        values.put(key, value);
    }

    /**
     * adds a pair to the table
     * @param key
     * @param value <code>table[key] += value</code>
     * @throws AlphaOmegaExeption if set already contain value
     */
    public void add(Object key, Object value) throws AlphaOmegaExeption {
        if (values.containsKey(value)) throw new AlphaOmegaExeption("set already contains "+value);
        values.put(key, value);
    }

    /**
     * @return returns size of table
     */
    public int size() {
        return values.size();
    }

    /**
     * clears the table
     */
    public void clear() {
        values.clear();
    }

    /**
     * @return true if table is empty
     */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * @param key
     * @return returns true if <code>table[key]</code> is pressent
     */
    public boolean contains(Object key) {
        return values.get(key) != null;
    }

    /**
     * @param obj
     * @return returns true if table can provide obj
     */
    public boolean has(Object obj) {
        return values.containsValue(obj);
    }

    /**
     * @param o
     * @return returns the key of the first occurrence of <code>o</code> if pressent otherwise it returns null
     */
    public Object keyOf(Object o) {
        for (Entry<Object, Object> entry : values.entrySet()) {
            if (Objects.equals(entry.getValue(), o)) return entry.getKey();
        }
        return null;
    }

    /**
     * removes the value at <code>key</code>
     * @param key
     * @return returns the value that was removed
     * @throws AlphaOmegaExeption if key is not pressent
     */
    public Object remove(Object key) throws AlphaOmegaExeption {
        if (values.containsKey(key)) throw new AlphaOmegaExeption(key+" is not pressent");
        return values.remove(key);
    }

    @Override
    public Iterator<Object> iterator() {
        return values.keySet().iterator();
    }

    public Collection<Object> values() {
        return values.values();
    }

    @Override
    public String toString() {
        String out = "(";
        for (Entry<Object, Object> element : values.entrySet()) {
            out += (out.endsWith(" ") || out.endsWith("(")?"":" ")+stringify(element.getKey())+"->"+stringify(element.getValue());
        }
        return out+")";
    }
}
