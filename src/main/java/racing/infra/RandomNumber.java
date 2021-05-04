package racing.infra;

public class RandomNumber {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;
    private final int randomNumber;

    private RandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static RandomNumber of(int randomNumber) {
        if (randomNumber < START_NUMBER || randomNumber > END_NUMBER) {
            throw new IllegalArgumentException("랜덤 숫자는 1부터 9까지입니다.");
        }
        return new RandomNumber(randomNumber);
    }

    public boolean isGreaterThanOrEqualTo(int number) {
        return this.randomNumber >= number;
    }
}
