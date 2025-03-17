package racing.entity;

import racing.rule.MoveRule;
import racing.view.RacingGameOutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int carCount;
    private final int roundCount;
    private final MoveRule moveRule;

    public RacingGame(int carCount, int roundCount, MoveRule moveRule) {
        this.carCount = carCount;
        this.roundCount = roundCount;
        this.moveRule = moveRule;
    }

    // 레이싱 게임 진행 (자동차 리스트 생성 => RoundCount 만큼 라운드 진행)
    public void playRacingGame() {
        RacingCars racingCars = new RacingCars(generateCars(carCount));

        RacingGameOutputView.printOutputHeadMessage();

        for (int i = 0; i < roundCount; i++) {
            playRound(racingCars);
            RacingGameOutputView.printRoundResult(racingCars);
        }
    }

    // 라운드 진행 (자동차 리스트 순회 => 전진 할 수 있다면 전진)
    private void playRound(RacingCars racingCars) {
        List<Car> cars = racingCars.getCars();
        for (Car car : cars) {
            if (moveRule.isMovable()) {
                car.move();
            }
        }
    }

    private static List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }

}
