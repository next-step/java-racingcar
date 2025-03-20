package racing.entity;

import racing.rule.RandomMoveRule;

import java.util.List;

public class RacingGame {
    private final RandomMoveRule randomMoveRule;

    public RacingGame(RandomMoveRule randomMoveRule) {
        this.randomMoveRule = randomMoveRule;
    }

    // 라운드 진행 (자동차 리스트 순회 => 전진 할 수 있다면 전진)
    public void playRound(RacingCars racingCars) {
        List<Car> cars = racingCars.getCarList();
        for (Car car : cars) {
            if (randomMoveRule.isMovableByRandomValue()) {
                car.move();
            }
        }
    }

}