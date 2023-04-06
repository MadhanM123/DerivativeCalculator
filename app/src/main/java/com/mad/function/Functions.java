package com.mad.function;

/**
 * The builtin functions available for use
 */
public class Functions {
    private static final int COS = 0;
    private static final int SIN = 1;
    private static final int TAN = 2;
    private static final int SEC = 3;
    private static final int CSC = 4;
    private static final int COT = 5;
    private static final int ACOS = 6;
    private static final int ASIN = 7;
    private static final int ATAN = 8;
    private static final int SQRT = 9;
    private static final int CBRT = 10;
    private static final int ABS = 11;
    private static final int CEIL = 12;
    private static final int FLOOR = 13;
    private static final int POW = 14;
    private static final int EXP = 15;
    private static final int E = 16;
    private static final int LOG10 = 17;
    private static final int LOG2 = 18;
    private static final int LOG = 19;
    private static final int LOG1P = 20;
    private static final int DEG_TO_RAD = 21;
    private static final int RAD_TO_DEG = 22;

    private static final Function[] BUILT_IN_FUNCTIONS = new Function[23];

    static{
        BUILT_IN_FUNCTIONS[COS] = new Function("cos") {
            @Override
            public double apply(double... args){
                return Math.cos(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[SIN] = new Function("sin") {
            @Override
            public double apply(double... args){
                return Math.sin(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[TAN] = new Function("tan") {
            @Override
            public double apply(double... args){
                return Math.tan(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[SEC] = new Function("sec") {
            @Override
            public double apply(double... args){
                double cos = Math.cos(args[0]);
                if(cos == 0.0){
                    throw new ArithmeticException("Division by zero in sec!");
                }
                return 1.0 / cos;
            }
        };
        BUILT_IN_FUNCTIONS[CSC] = new Function("csc") {
            @Override
            public double apply(double... args){
                double sin = Math.sin(args[0]);
                if(sin == 0.0){
                    throw new ArithmeticException("Division by zero in csc!");
                }
                return 1.0 / sin;
            }
        };
        BUILT_IN_FUNCTIONS[COT] = new Function("cot") {
            @Override
            public double apply(double... args){
                double tan = Math.tan(args[0]);
                if(tan == 0.0){
                    throw new ArithmeticException("Division by zero in cot!");
                }
                return 1.0 / tan;
            }
        };
        BUILT_IN_FUNCTIONS[ACOS] = new Function("acos") {
            @Override
            public double apply(double... args){
                return Math.acos(args[0]);
            }
        };

    }
}
