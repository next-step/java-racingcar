package step2;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(int number) {
        checkPositive(number);
        this.number = number;
    }

    private void checkPositive(int number) {
        if(number < 0) throw new RuntimeException("양수의 숫자만 유효합니다.");
    }

    int intValue(){
        return number;
    }
}
