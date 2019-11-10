package step1.calculator;

public enum Operator {
    PLUS_OPERATOR("+"),
    MINUS_OPERATOR("-"),
    MULTIPLY_OPERATOR("*"),
    DIVIDE_OPERATOR("/");

    private String name;

    Operator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static boolean isEqualPlusOperator(String arg){
        if(PLUS_OPERATOR.getName().equals(arg)){
            return true;
        }
        return false;
    }

    public static boolean isEqualMinusOperator(String arg){
        if(MINUS_OPERATOR.getName().equals(arg)){
            return true;
        }
        return false;
    }

    public static boolean isEqualMultiplyOperator(String arg){
        if(MULTIPLY_OPERATOR.getName().equals(arg)){
            return true;
        }
        return false;
    }

    public static boolean isEqualDivideOperator(String arg){
        if(DIVIDE_OPERATOR.getName().equals(arg)){
            return true;
        }
        return false;
    }
}
