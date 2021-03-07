package step2;

public class StringParser {
    public static int toInt(String str) {
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("입력된 문자열은 숫자형식이 아닙니다.");
        }
        return num;
    }
}
