package com.alphaomega;

import java.util.HashSet;
import java.util.Iterator;


public class GreekSet implements Iterable<Object> {
    protected final HashSet<Object> values = new HashSet<>();

    /**
     * adds a value if not pressent to the set
     * @param index
     * @param value <code>set += value</code>
     */
    public void set(Object value) {
        values.add(value);
    }

    /**
     * adds a value to the set
     * @param value <code>list += value</code>
     * @throws AlphaOmegaExeption if set already contain value
     */
    public void add(Object value) throws AlphaOmegaExeption {
        if (values.contains(value)) throw new AlphaOmegaExeption("set already contains "+value);
        values.add(value);
    }

    /**
     * @return returns size of set
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
     * @return true if set is empty
     */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * @param index
     * @return returns true if <code>list[index]</code> is pressent
     */
    public boolean contains(Object o) {
        return values.contains(o);
    }


    /**
     * removes <code>o</code> from the set
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
        return values.toString().replace("[", "(").replace("]", ")");
    }
}
