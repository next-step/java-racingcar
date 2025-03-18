package racing.entity;

import racing.rule.RandomMoveRule;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final RandomMoveRule randomMoveRule;

    private int maxPosition;

    public RacingGame(RandomMoveRule randomMoveRule) {
        this.randomMoveRule = randomMoveRule;
    }

    // 라운드 진행 (자동차 리스트 순회 => 전진 할 수 있다면 전진)
    public void playRound(RacingCars racingCars) {
        List<Car> cars = racingCars.getCars();
        for (Car car : cars) {
            if (randomMoveRule.isMovableByRandomValue()) {
                car.move();
                updateMaxPosition(car.getPosition());
            }
        }
    }

    // 레이싱 게임 우승자 발표 (우승자 1명 이상 가능)
    public List<String> getWinners(RacingCars racingCars) {
        List<String> winners = new ArrayList<>();

        List<Car> carList = racingCars.getCars();
        for (Car car : carList) {
            int position = car.getPosition();
            String carName = car.getCarName();

            if (position == maxPosition) {
                winners.add(carName);
            }
        }

        return winners;
    }

    private void updateMaxPosition(int position) {
        maxPosition = Math.max(maxPosition, position);
    }

}