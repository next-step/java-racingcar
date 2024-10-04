package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.RandomMove;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<RacingCar> racingCar = new ArrayList<>();
    private int matchCount;

    public RacingGame(int carNumber, int matchCount) {
        this.matchCount = matchCount;
        for (int i = 0; i < carNumber; i++) {
            racingCar.add(new RacingCar());
        }
    }

    public boolean isMatching() {
        return matchCount > 0;
    }

    public void match() {
        if (matchCount > 0) {
            movingCars();
            matchCount--;
        }
    }

    private void movingCars() {
        for (RacingCar car : racingCar) {
            car.move(RandomMove.getInstance().movable());
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    /**
     * 도메인 계층에서 getter로 전달하면 도메인 계층에 직접 참조하고,
     * getter로 clear하는 문제가 생길 수 있으므로
     * Integer 클래스로 복사해서 반환
     */
    public List<Integer> getRacingCarsPosition() {
        List<Integer> result = new ArrayList<>();
        for (RacingCar car : racingCar) {
            result.add(car.getPosition());
        }
        return result;
    }
}
