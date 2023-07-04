package racingcar;

public class RacingManager {
    private static final String WINNERS_STRING = "가 최종 우승했습니다.";

    private final Cars cars;

    public RacingManager(Cars cars) {
        this.cars = cars;
    }

    public Cars playRacing() {
        cars.takeTurn();
        return cars;
    }
}
