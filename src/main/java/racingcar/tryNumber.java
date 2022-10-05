package racingcar;

public class tryNumber {
    private int number;

    public tryNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("시도횟수는 0이상만 가능합니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
