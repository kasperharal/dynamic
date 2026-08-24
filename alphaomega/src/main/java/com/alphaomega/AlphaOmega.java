package com.alphaomega;

public class AlphaOmega {
    /**
     * get boolean value
     * @param obj
     * @return returns boolean value of <code>obj</code>
     * @throws AlphaOmegaExeption if <code>obj</code> is not a boolean
     */
    public static boolean booleanOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Boolean b) return b;
        else throw new AlphaOmegaExeption("value is not a boolean");
    }

    /**
     * get byte value
     * @param obj
     * @return returns byte value of <code>obj</code>
     * @throws AlphaOmegaExeption if <code>obj</code> is not a byte
     */
    public static byte byteOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b.byteValue();
        else throw new AlphaOmegaExeption("value is not a byte");
    }

    /**
     * get short value
     * @param obj
     * @return returns short value of <code>obj</code>
     * @throws AlphaOmegaExeption if <code>obj</code> is not a short
     */
    public static short shortOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b.shortValue();
        else throw new AlphaOmegaExeption("value is not a short");
    }

    /**
     * get int value
     * @param obj
     * @return returns int value of <code>obj</code>
     * @throws AlphaOmegaExeption if <code>obj</code> is not a int
     */
    public static int intOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b.intValue();
        else throw new AlphaOmegaExeption("value is not a int");
    }

    /**
     * get long value
     * @param obj
     * @return returns long value of <code>obj</code>
     * @throws AlphaOmegaExeption if <code>obj</code> is not a long
     */
    public static long longOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b.longValue();
        else throw new AlphaOmegaExeption("value is not a long");
    }

    /**
     * get float value
     * @param obj
     * @return returns float value of <code>obj</code>
     * @throws AlphaOmegaExeption if <code>obj</code> is not a float
     */
    public static float floatOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b.floatValue();
        else throw new AlphaOmegaExeption("value is not a float");
    }

    /**
     * get double value
     * @param obj
     * @return returns double value of <code>obj</code>
     * @throws AlphaOmegaExeption if <code>obj</code> is not a double
     */
    public static double doubleOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b.doubleValue();
        else throw new AlphaOmegaExeption("value is not a double");
    }

    /**
     * get Number value
     * @param obj
     * @return returns Number value of <code>obj</code>
     * @throws AlphaOmegaExeption if <code>obj</code> is not a Number
     */
    public static Number numberOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof Number b) return b;
        else throw new AlphaOmegaExeption("value is not a Number");
    }

    /**
     * get String value
     * @param obj
     * @return returns String value of <code>obj</code>
     * @throws AlphaOmegaExeption if <code>obj</code> is not a String
     */
    public static String stringOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof String b) return b;
        else throw new AlphaOmegaExeption("value is not a String");
    }

    /**
     * get map value
     * @param obj
     * @return returns map value of <code>obj</code>
     * @throws AlphaOmegaExeption if <code>obj</code> is not a map
     */
    public static GreekMap mapOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof GreekMap b) return b;
        else throw new AlphaOmegaExeption("value is not a map");
    }

    /**
     * get set value
     * @param obj
     * @return returns set value of <code>obj</code>
     * @throws AlphaOmegaExeption if <code>obj</code> is not a set
     */
    public static GreekSet setOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof GreekSet b) return b;
        else throw new AlphaOmegaExeption("value is not a set");
    }

    /**
     * get list value
     * @param obj
     * @return returns list value of <code>obj</code>
     * @throws AlphaOmegaExeption if <code>obj</code> is not a list
     */
    public static GreekList listOf(Object obj) throws AlphaOmegaExeption {
        if (obj instanceof GreekList b) return b;
        else throw new AlphaOmegaExeption("value is not a list");
    }
}
