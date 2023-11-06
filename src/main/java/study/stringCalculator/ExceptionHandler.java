package study.stringCalculator;

public class ExceptionHandler {
    private boolean isNegativeNumber = false;
    private boolean isNumber = true;

    public void checkNegativeNumber(int value) {
        if (value < 0) {  // 음수 검사
            throw new IllegalArgumentException("해당 값은 음수입니다.");
        }
    }
}
