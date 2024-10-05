package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.RandomMove;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static RacingGame INSTANCE = null;

    public static RacingGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RacingGame();
        }
        return INSTANCE;
    }


    public boolean isMatching(int matchCount) {
        return matchCount > 0;
    }

    public int match(int matchCount, List<RacingCar> racingCars) {
        if (matchCount > 0) {
            movingCars(racingCars);
            matchCount--;
        }
        return matchCount;
    }

    private void movingCars(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            car.move(RandomMove.getInstance().movable());
        }
    }

    /**
     * 도메인 계층에서 getter로 전달하면 도메인 계층에 직접 참조하고,
     * getter로 clear하는 문제가 생길 수 있으므로
     * Integer 클래스로 복사해서 반환
     */
    public List<Integer> getRacingCarsPosition(List<RacingCar> racingCars) {
        List<Integer> result = new ArrayList<>();
        for (RacingCar car : racingCars) {
            result.add(car.getPosition());
        }
        return result;
    }

    public List<RacingCar> createRacingCars(int carNumber) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new RacingCar());
        }
        return cars;
    }
}
