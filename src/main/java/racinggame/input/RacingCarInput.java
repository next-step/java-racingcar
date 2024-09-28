package racinggame.input;

public class RacingCarInput {
    public final static int MIN_CAR_COUNT = 2;
    private final int carCount;

    private RacingCarInput(int carCount) {
        this.carCount = carCount;
    }

    public static RacingCarInput from(final int input) {
        if (input < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("자동차는 최소 " + MIN_CAR_COUNT + "대 이상이여야 합니다.");
        }

        return new RacingCarInput(input);
    }

    public int getCarCount() {
        return carCount;
    }
}
