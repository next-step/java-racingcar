package step3.validite;

public class ValidityCheck {

    private static final int INPUT_CONDITION_NUMBER = 0;

    public static int positiveNumberCheck(Integer number) {
        try {
            if (number >= INPUT_CONDITION_NUMBER) {
                return number;
            }
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요.");
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
