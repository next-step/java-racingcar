package step2;

public class Validator {
    static void nullEmptyCheck(String expression){
        if(expression == null || expression.trim().isEmpty()){
            throw new IllegalArgumentException("Null OR Empty");
        }
    }

    static boolean isDigit(String operand){
        String numberRegExp = "^[0-9]+$";
        if(operand.matches(numberRegExp)){
            return true;
        }
        return false;
    }

    static boolean isOperator(String operator){
        String operatorRegExp = "[+*/-]";
        if(operator.matches(operatorRegExp)){
            return true;
        }
        return false;
    }
}
