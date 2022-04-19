package racingcar.racing.dto;

public class RacingGameParam {
    private final int carNumber;
    private final int tryNumber;
    private final String[] names;

    public RacingGameParam(int carNumber, int tryNumber, String[] names) {
        this.carNumber = carNumber;
        this.tryNumber = tryNumber;
        this.names = names;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
