package step03;

public class ValidateUtils {

    public static void inputIsZero(int input1, int input2) {
        if (input1 == 0 || input2 == 0) {
            throw new IllegalArgumentException("입력값은 0 이상이어야 합니다.");
        }
    }
}
