package step2;

public class Validator {

    static String[] validateExpression(String input){
        checkNullOrEmpty(input);
        //두 개 이상 연속한 공백으로도 분리하기 위한 정규표현식
        String[] expression = input.split("\\s+");
        checkExpressionLength(expression.length);
        return expression;
    }

    // 계산식의 항의 개수가 홀수개인지 확인
    private static void checkExpressionLength(int expressionLength){
        if(expressionLength % 2 == 1){
            throw new IllegalArgumentException("Invalid number of terms");
        }
    }

    public static void checkNullOrEmpty(String expression){
        if(expression == null || expression.trim().isEmpty()){
            throw new IllegalArgumentException("This is NULL Or EMPTY");
        }
    }

    public static void checkDigit(String operand){
        String numberRegExp = "^[0-9]+$";
        if(!operand.matches(numberRegExp)){
            throw new IllegalArgumentException("This is NOT a DIGIT");
        }
    }

    public static void checkOperator(String operator){
        String operatorRegExp = "[+*/-]";
        if(!operator.matches(operatorRegExp)){
            throw new IllegalArgumentException("This is NOT an OPERATOR");
        }
    }

    public static void checkZero(long divisor){
        if(divisor == 0) {
            throw new ArithmeticException("Do Not Divide by ZERO");
        }
    }
}
