package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 자동차 경주 게임 클래스
 */
public class RacingGame {

    private final int carCount;                         // 자동차 수
    private final int moveCount;                        // 이동횟수
    private final TryCount tryCount;                    // 시도횟수
    private final RacingCars racingResultCars;          // 경주용 자동차 결과 목록

    public RacingGame(int carCount, int moveCount) {
        this.carCount = carCount;
        this.moveCount = moveCount;
        this.tryCount = new TryCount(moveCount);
        this.racingResultCars = new RacingCars(new ArrayList<>());
    }

    public boolean hasTryCount() {
        return tryCount.hasTryCount();
    }

    public RacingCars start() {
        tryCount.executeGame();
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            RacingCar racingCar = createRacingCar(i);
            racingCar(racingCar);
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

    private void racingCar(RacingCar car) {
        for (int i = 0; i < moveCount; i++) {
            Random random = new Random();
            car.race(new RandomNumber(random.nextInt(10)));
        }
    }

}