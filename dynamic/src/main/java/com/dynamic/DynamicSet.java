package com.dynamic;

import static com.dynamic.Dynamic.stringify;

import java.util.HashSet;
import java.util.Iterator;


public class DynamicSet implements Iterable<Object> {
    protected final HashSet<Object> values;
    
    public DynamicSet()  {
        values = new HashSet<>();
    }

    
    public DynamicSet(String src) throws DynamicExeption {
        values = new DynamicParser(src).getSet().values;
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
