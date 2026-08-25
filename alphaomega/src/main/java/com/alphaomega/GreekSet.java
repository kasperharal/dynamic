package com.alphaomega;

import java.util.HashSet;
import java.util.Iterator;
import static com.alphaomega.AlphaOmega.stringify;


public class GreekSet implements Iterable<Object> {
    protected final HashSet<Object> values;

    /**
     * creates a new GreekSet
     */
    public GreekSet()  {
        values = new HashSet<>();
    }

    /**
     * creates a new AlphaOmegaParser and gets a set from it
     */
    public GreekSet(String src) throws AlphaOmegaExeption {
        values = new AlphaOmegaParser(src).getSet().values;
    }


    /**
     * adds a value to the set
     * @param index
     * @param value <code>set[index] += value</code>
     * @throws AlphaOmegaExeption if value is already pressent
     */
    public void add(Object value) throws AlphaOmegaExeption {
        if (values.contains(value)) throw new AlphaOmegaExeption("value already exists");
        values.add(value);
    }

    /**
     * @return returns size of set
     */
    public int size() {
        return values.size();
    }

    /**
     * clears the set
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
     * @param o
     * @return returns true if <code>set[o]</code> is pressent
     */
    public boolean contains(Object o) {
        return values.contains(o);
    }


    /**
     * removes <code>o</code> from the set if pressent
     * @param o
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
        String out = "![";
        for (Object element : values) {
            out += (out.endsWith(" ") || out.endsWith("[")?"":" ")+stringify(element);
        }
        return out+"]";
    }
}
