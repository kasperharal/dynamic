package com.darkcultist.dynamic;

public class Dynamic {
    
    public static boolean booleanOf(Object obj) throws DynamicExeption {
        if (obj instanceof Boolean b) return b;
        else throw new DynamicExeption("value is not a boolean");
    }

    
    public static byte byteOf(Object obj) throws DynamicExeption {
        if (obj instanceof Number b) return b.byteValue();
        else throw new DynamicExeption("value is not a byte");
    }

    
    public static short shortOf(Object obj) throws DynamicExeption {
        if (obj instanceof Number b) return b.shortValue();
        else throw new DynamicExeption("value is not a short");
    }

    
    public static int intOf(Object obj) throws DynamicExeption {
        if (obj instanceof Number b) return b.intValue();
        else throw new DynamicExeption("value is not a int");
    }

    
    public static long longOf(Object obj) throws DynamicExeption {
        if (obj instanceof Number b) return b.longValue();
        else throw new DynamicExeption("value is not a long");
    }

    
    public static float floatOf(Object obj) throws DynamicExeption {
        if (obj instanceof Number b) return b.floatValue();
        else throw new DynamicExeption("value is not a float");
    }

    
    public static double doubleOf(Object obj) throws DynamicExeption {
        if (obj instanceof Number b) return b.doubleValue();
        else throw new DynamicExeption("value is not a double");
    }

    
    public static Number numberOf(Object obj) throws DynamicExeption {
        if (obj instanceof Number b) return b;
        else throw new DynamicExeption("value is not a Number");
    }

    
    public static String stringOf(Object obj) throws DynamicExeption {
        if (obj instanceof String b) return b;
        else throw new DynamicExeption("value is not a String");
    }

    
    public static DynamicMap mapOf(Object obj) throws DynamicExeption {
        if (obj instanceof DynamicMap b) return b;
        else throw new DynamicExeption("value is not a map");
    }

    
    public static DynamicList listOf(Object obj) throws DynamicExeption {
        if (obj instanceof DynamicList b) return b;
        else throw new DynamicExeption("value is not a list");
    }

    public static String stringify(Object obj) {
        if (obj == null) return "null";
        else if (obj instanceof String str) return '"'+str+'"';
        else return obj.toString();
    }
}
