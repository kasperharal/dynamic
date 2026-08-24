package com.alphaomega;

import java.util.ArrayList;
import java.util.Iterator;


public class GreekList implements Iterable<Object> {
    protected final ArrayList<Object> values = new ArrayList<>();

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
        return object instanceof Boolean b?b:null;
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
        return object instanceof Byte b?b:null;
    }

    /**
     * gets byte value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is byte otherwise it returns <code>defaultValue</code>
     */
    public byte optByte(int index, byte defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Byte b?b:null;
    }

    /**
     * gets byte value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a byte
     */
    public byte getByte(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Byte b) return b;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets short value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is short otherwise it returns <code>null</code>
     */
    public short optShort(int index) {
        Object object = this.opt(index);
        return object instanceof Short b?b:null;
    }

    /**
     * gets short value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is short otherwise it returns <code>defaultValue</code>
     */
    public short optShort(int index, short defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Short b?b:null;
    }

    /**
     * gets short value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a short
     */
    public short getShort(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Short b) return b;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets int value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is int otherwise it returns <code>null</code>
     */
    public int optInt(int index) {
        Object object = this.opt(index);
        return object instanceof Integer b?b:null;
    }

    /**
     * gets int value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is int otherwise it returns <code>defaultValue</code>
     */
    public int optInt(int index, int defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Integer b?b:null;
    }

    /**
     * gets int value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a int
     */
    public int getInt(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Integer b) return b;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets long value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is long otherwise it returns <code>null</code>
     */
    public long optLong(int index) {
        Object object = this.opt(index);
        return object instanceof Long b?b:null;
    }

    /**
     * gets long value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is long otherwise it returns <code>defaultValue</code>
     */
    public long optLong(int index, long defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Long b?b:null;
    }

    /**
     * gets long value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a long
     */
    public long getLong(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Long b) return b;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets float value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is float otherwise it returns <code>null</code>
     */
    public float optFloat(int index) {
        Object object = this.opt(index);
        return object instanceof Float b?b:null;
    }

    /**
     * gets float value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is float otherwise it returns <code>defaultValue</code>
     */
    public float optFloat(int index, float defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Float b?b:null;
    }

    /**
     * gets float value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a float
     */
    public float getFloat(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Float b) return b;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets double value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is double otherwise it returns <code>null</code>
     */
    public double optDouble(int index) {
        Object object = this.opt(index);
        return object instanceof Double b?b:null;
    }

    /**
     * gets double value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is double otherwise it returns <code>defaultValue</code>
     */
    public double optDouble(int index, double defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Double b?b:null;
    }

    /**
     * gets double value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a double
     */
    public double getDouble(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Double b) return b;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets number value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is number otherwise it returns <code>null</code>
     */
    public Number optNumber(int index) {
        Object object = this.opt(index);
        return object instanceof Number b?b:null;
    }

    /**
     * gets number value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is number otherwise it returns <code>defaultValue</code>
     */
    public Number optNumber(int index, Number defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof Number b?b:null;
    }

    /**
     * gets number value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a number
     */
    public Number getNumber(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof Number b) return b;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets list value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is list otherwise it returns <code>null</code>
     */
    public GreekList optList(int index) {
        Object object = this.opt(index);
        return object instanceof GreekList b?b:null;
    }

    /**
     * gets list value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is list otherwise it returns <code>defaultValue</code>
     */
    public GreekList optList(int index, GreekList defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof GreekList b?b:null;
    }

    /**
     * gets list value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a list
     */
    public GreekList getList(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof GreekList b) return b;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets set value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is set otherwise it returns <code>null</code>
     */
    public GreekSet optSet(int index) {
        Object object = this.opt(index);
        return object instanceof GreekSet b?b:null;
    }

    /**
     * gets set value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is set otherwise it returns <code>defaultValue</code>
     */
    public GreekSet optSet(int index, GreekSet defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof GreekSet b?b:null;
    }

    /**
     * gets set value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a set
     */
    public GreekSet getSet(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof GreekSet b) return b;
        else throw new AlphaOmegaExeption("list["+index+"] was not found");
    }

    /**
     * gets map value or null
     * @param index
     * @return returns <code>list[index]</code> if pressent and is map otherwise it returns <code>null</code>
     */
    public GreekMap optMap(int index) {
        Object object = this.opt(index);
        return object instanceof GreekMap b?b:null;
    }

    /**
     * gets map value or default
     * @param index
     * @param defaultValue
     * @return returns <code>list[index]</code> if pressent and is map otherwise it returns <code>defaultValue</code>
     */
    public GreekMap optMap(int index, GreekMap defaultValue) {
        Object object = this.opt(index, defaultValue);
        return object instanceof GreekMap b?b:null;
    }

    /**
     * gets map value
     * @param index
     * @return returns <code>list[index]</code>
     * @throws AlphaOmegaExeption if value is not pressent or not a map
     */
    public GreekMap getMap(int index) throws AlphaOmegaExeption {
        Object object = this.get(index);
        if (object instanceof GreekMap b) return b;
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
        return values.toString();
    }
}
