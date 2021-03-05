package calculator;


public final class Validator {

    public static void isBlankOrEmpty(String input) {
        if(isBlank(input) || isEmpty(input)) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자열입니다.");
        }
    }

    private static boolean isEmpty(String input) {
        return input.equals("");
    }

    public static boolean isBlank(String input) {
        return input.equals(" ");
    }

    public static void isNotOperation(String input) {
        if(!Operator.isOperation(input)) {
            throw new IllegalArgumentException("입력된 사칙연산 기호가 잘못된 사칙연산 기호입니다.");
        }
    }

    public static void isNumberAndOperation(String[] data) {
        isBlankOrEmpty(data[0]);
        for(int i = 1; i< data.length; i = i + 2) {
            isNotOperation(data[i]);
            isBlankOrEmpty(data[i+1]);
        }
    }
}
