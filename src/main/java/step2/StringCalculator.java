package step2;

public class StringCalculator {

    public int calculate(String data) {
        checkInputValidation(data);

        return 0;
    }

    private void checkInputValidation(String data) {
        if(data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    public int plus(int first, int second) {
        return first + second;
    }

    public int minus(int first, int second) {
        return first - second;
    }

    public int multiple(int first, int second) {
        return first * second;
    }

    public int divide(int first, int second) {
        if(second == 0) {
            throw new IllegalArgumentException("숫자 0으로 나눌 수 없습니다.");
        }
        return first / second;
    }

}
