package racing.entity;

import racing.generator.CarsGenerator;
import racing.rule.RandomMoveRule;
import racing.view.RacingGameOutputView;

import java.util.List;

public class RacingGame {
    private final int carCount;
    private final int roundCount;
    private final RandomMoveRule randomMoveRule;

    public RacingGame(int carCount, int roundCount, RandomMoveRule randomMoveRule) {
        this.carCount = carCount;
        this.roundCount = roundCount;
        this.randomMoveRule = randomMoveRule;
    }

    // 레이싱 게임 진행 (자동차 리스트 생성 => RoundCount 만큼 라운드 진행)
    public void playRacingGame() {
        RacingCars racingCars = new RacingCars(CarsGenerator.generateCars(carCount));

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
            if (randomMoveRule.isMovableByRandomValue()) {
                car.move();
            }
        }
    }

}