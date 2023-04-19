package step3.racing;


import java.util.ArrayList;
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
        this.cars = setupCars(carsCount);
    }

    private void validEnoughCarsCount(int carsCount) {
        if (carsCount < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }

    private Cars setupCars(int carsCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carsCount; i++) {
            carList.add(new Car());
        }
        return new Cars(carList);
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
            this.cars.moveAll();
        }
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
}
