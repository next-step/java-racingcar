package racing.domain;

public class TryCount {

    private final int number;

    public TryCount(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
        this.number = number;
    }

    public int getTryCount() {
        return number;
    }
}
