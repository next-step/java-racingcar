package step3;

public class ValidityCheck {

    public static boolean positiveNumberCheck(int number) {
        try {
            if (number >= 0) {
                return true;
            }
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요.");
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
