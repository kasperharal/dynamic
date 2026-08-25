package com.alphaomega;

import java.util.HashSet;
import java.util.Iterator;
import static com.alphaomega.AlphaOmega.stringify;


public class GreekSet implements Iterable<Object> {
    protected final HashSet<Object> values;
    
    public GreekSet()  {
        values = new HashSet<>();
    }

    
    public GreekSet(String src) throws AlphaOmegaExeption {
        values = new AlphaOmegaParser(src).getSet().values;
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

    
    public Object remove(Object o) {
        return values.remove(o);
    }
    
    @Override
    public Iterator<Object> iterator() {
        return values.iterator();
    }

    @Override
    public String toString() {
        String out = "(";
        for (Object element : values) {
            out += (out.endsWith(" ") || out.endsWith("(")?"":" ")+stringify(element);
        }
        return out+")";
    }
}
