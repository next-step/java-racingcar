package calculator.utils;

public class StringUtil {

    public static void checkBlank(String expression) {
        if(expression == null || expression.trim().length() == 0){
            throw new IllegalArgumentException("입력값이 NULL 혹은 빈 공백 문자입니다.");
        }
    }
    public static String[] split(String expression) {
        return expression.split(" ");
    }

}
