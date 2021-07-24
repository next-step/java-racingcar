package stringCalculator;

public class Validate {
    public static void checkIsEmpty(String aText){
        if (!textHasContent(aText)) {
            throw new IllegalArgumentException("공백 문자를 입력하였습니다.");
        }
    }
    private static boolean textHasContent(String text){
        String EMPTY_STRING = "";
        return (text != null) && (!text.trim().equals(EMPTY_STRING));
    }

    public static void checkIsOperator(String operator) {
        if(!isOperator(operator)){
            throw new IllegalArgumentException("사칙연산 기호가 아닌 문자를 입력하였습니다.");
        }
    }

    private static boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

}
