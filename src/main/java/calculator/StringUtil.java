package calculator;

public class StringUtil {

    public static String[] splitInput(String input) {
        String[] strArr;
        try {
            strArr = input.split(" ");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("연산자의 값이 비어있습니다. 다시한번 확인해주세요");
        }
        return strArr;
    }

}
