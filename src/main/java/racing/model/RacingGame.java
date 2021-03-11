package racing.model;

import java.util.List;

public class RacingGame {

    private final RacingCars cars;

    public RacingGame(String[] racingCarNames) {
        this.cars = new RacingCars(racingCarNames);
    }

    /**
     * 조건에 따라 자동차를 이동시켜주는 메서드
     */
    public RacingCars moveAndStop(List<Integer> randomValue) {
        return cars.move(randomValue.iterator());
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

    public int carCount() {
        return cars.carCount();
    }
}
