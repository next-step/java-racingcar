package racingcar;

public class Round {

    private final int number;

    public Round(int number) {
        valid(number);
        this.number = number;
    }

    private void valid(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("라운드 횟수는 1번 이상이여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
