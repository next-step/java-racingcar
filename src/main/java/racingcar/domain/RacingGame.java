package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 자동차 경주 게임 클래스
 */
public class RacingGame {

    private final TryCount tryCount;                    // 시도횟수
    private final RacingCars racingResultCars;          // 경주용 자동차 결과 목록

    public RacingGame(int tryCount) {
        this.tryCount = new TryCount(tryCount);
        this.racingResultCars = new RacingCars(new ArrayList<>());
    }

    public boolean hasTryCount() {
        return tryCount.hasTryCount();
    }

    public RacingCars start(int carCount, int moveCount) {
        tryCount.executeGame();
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            RacingCar racingCar = createRacingCar(i);
            moveCar(racingCar, moveCount);
            this.racingResultCars.addRacingCars(racingCar);
            racingCarList.add(racingCar);
        }
        return new RacingCars(racingCarList);
    }

    public RacingCars pickWinners() {
        return this.racingResultCars.pickWinners();
    }

    protected RacingCar createRacingCar(int index) {
        return new RacingCar();
    }

    private void moveCar(RacingCar car, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            Random random = new Random();
            car.race(new RandomNumber(random.nextInt(10)));
        }
    }

}