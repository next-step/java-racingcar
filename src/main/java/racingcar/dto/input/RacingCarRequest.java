package racingcar.dto.input;

public class RacingCarRequest {

    private final CarNames carNames;
    private final RacingCount racingCount;

    public RacingCarRequest(String names, int racingCount) {
        this(new CarNames(names), new RacingCount(racingCount));
    }

    public RacingCarRequest(CarNames carNames, RacingCount racingCount) {
        this.carNames = carNames;
        this.racingCount = racingCount;
    }

    public CarNames getCarNames() {
        return carNames;
    }

    public RacingCount getRacingCount() {
        return racingCount;
    }
}
