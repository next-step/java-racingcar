package racing.domain;

public class NumberOfRound {
    public int number;

    public NumberOfRound(final int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
        this.number = number;
    }
}
