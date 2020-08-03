package com.hskim.nextstep.step02;


import java.util.function.BiFunction;

public enum ArithmeticOperator {

    ADDITION("add", '+'),
    SUBTRACT("sub", '-'),
    MULTIPLICATION("mult", '*'),
    DIVISION("div", '/');

    private String alias;
    private char sign;
    private BiFunction<String, String, Integer> operator;

    ArithmeticOperator(String alias, char sign) {

        this.alias = alias;
        this.sign = sign;
        this.operator = makeOperator();
    }

    private BiFunction<String, String, Integer> makeOperator() {

        return (s1, s2) -> {

            argumentValidator(s1);
            argumentValidator(s2);

            switch (sign) {
                case '+':
                    return Integer.parseInt(s1) + Integer.parseInt(s2);
                case '-':
                    return Integer.parseInt(s1) - Integer.parseInt(s2);
                case '*':
                    return Integer.parseInt(s1) * Integer.parseInt(s2);
                case '/':
                    return Integer.parseInt(s1) / Integer.parseInt(s2);

                default:
                    throw new IllegalArgumentException();
            }
        };
    }

    /*
     * Validate Empty String ("") or null
     * Throw IllegalArgumentException if argument is empty or null
     */
    private void argumentValidator(String argument) {

        if(argument == null || argument.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public int calculate(String s1, String s2) {

        return operator.apply(s1, s2);
    }

    public static boolean contains(String sign) {

        for(ArithmeticOperator arithmeticOperator : ArithmeticOperator.values()) {
            if(sign.equals(String.valueOf(arithmeticOperator.sign))) {
                return true;
            }
        }

        return false;
    }

    public static ArithmeticOperator getArithmeticOperatorBySign(String sign) {

        for(ArithmeticOperator arithmeticOperator : ArithmeticOperator.values()) {
            if(sign.equals(String.valueOf(arithmeticOperator.sign))){
                return arithmeticOperator;
            }
        }

        throw new IllegalArgumentException();
    }
}
