package step3.racing;


import step3.util.RandomGenerator;

import java.util.List;

/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class CarRacingGame {

    private final Cars cars;
    private RacingResult racingResult;

    public CarRacingGame(int carsCount) {
        validEnoughCarsCount(carsCount);
        this.cars = makeCars(carsCount);
    }

    private static void validEnoughCarsCount(int carsCount) {
        if (carsCount < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }

    private Cars makeCars(int carsCount) {
        Cars cars = new Cars();
        for (int i = 0; i < carsCount; i++) {
            cars.addCar(new Car());
        }
        return cars;
    }

    public void start(int roundsCount) {
        validNotStartedRace();
        validEnoughRounds(roundsCount);
        doRounds(roundsCount);
        recordResult();
    }

    private void validNotStartedRace() {
        if (this.racingResult != null) {
            throw new IllegalStateException("이미 경기가 종료되었습니다.");
        }
    }

    private void validEnoughRounds(int roundsCount) {
        if (roundsCount < 1) {
            throw new IllegalArgumentException("라운드는 1회 이상이어야 합니다.");
        }
    }

    private void doRounds(int roundsCount) {
        for (int i = 0; i < roundsCount; i++) {
            doRound();
        }
    }

    private void doRound() {
        List<Car> carList = this.cars.unmodifiableList();
        carList.parallelStream().forEach(car -> {
            int random = RandomGenerator.generate(0, 9);
            CarActionDecider.action(random).accept(car);
        });
    }

    private void recordResult() {
        List<Car> deepCopyCarList = this.cars.deepCopyList();
        this.racingResult = new RacingResult(deepCopyCarList);
    }

    public RacingResult result() {
        validStartedRace();
        return this.racingResult;
    }

    private void validStartedRace() {
        if (this.racingResult == null) {
            throw new IllegalStateException("경기가 시작되기 전에는 결과를 얻을 수 없습니다.");
        }
    }

    public int carsCount() {
        return this.cars.count();
    }

}
