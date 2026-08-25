package com.alphaomega;

public class AlphaOmega {
    
    public static boolean booleanOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Boolean b) return b;
        else throw new AlphaOmegaExeption("value is not a boolean");
    }

    
    public static byte byteOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b.byteValue();
        else throw new AlphaOmegaExeption("value is not a byte");
    }

    
    public static short shortOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b.shortValue();
        else throw new AlphaOmegaExeption("value is not a short");
    }

    
    public static int intOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b.intValue();
        else throw new AlphaOmegaExeption("value is not a int");
    }

    
    public static long longOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b.longValue();
        else throw new AlphaOmegaExeption("value is not a long");
    }

    
    public static float floatOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b.floatValue();
        else throw new AlphaOmegaExeption("value is not a float");
    }

    
    public static double doubleOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b.doubleValue();
        else throw new AlphaOmegaExeption("value is not a double");
    }

    
    public static Number numberOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b;
        else throw new AlphaOmegaExeption("value is not a Number");
    }

    
    public static String stringOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof String b) return b;
        else throw new AlphaOmegaExeption("value is not a String");
    }

    
    public static GreekMap mapOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof GreekMap b) return b;
        else throw new AlphaOmegaExeption("value is not a map");
    }

    
    public static GreekSet setOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof GreekSet b) return b;
        else throw new AlphaOmegaExeption("value is not a set");
    }

    
    public static GreekList listOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof GreekList b) return b;
        else throw new AlphaOmegaExeption("value is not a list");
    }

    public static String stringify(Object obj) {
        if (obj == null) return "null";
        else if (obj instanceof String str) return '"'+str+'"';
        else return obj.toString();
    }
}
