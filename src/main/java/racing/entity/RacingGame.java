package racing.entity;

import racing.generator.CarsGenerator;
import racing.message.GameMessage;
import racing.rule.RandomMoveRule;
import racing.view.RacingGameInputView;
import racing.view.RacingGameOutputView;

import java.util.List;

public class RacingGame {
    private final List<String> carNames;
    private final int roundCount;
    private final RandomMoveRule randomMoveRule;

    private RacingGame(List<String> carNames, int roundCount, RandomMoveRule randomMoveRule) {
        this.carNames = carNames;
        this.roundCount = roundCount;
        this.randomMoveRule = randomMoveRule;
    }

    // 레이싱 게임 준비
    public static RacingGame readyRacingGame() {
        List<String> carNames = RacingGameInputView.getCarNamesInput(GameMessage.CAR_NAME_INPUT_MESSAGE);
        int roundCount = RacingGameInputView.getIntegerInput(GameMessage.ATTEMPT_COUNT_INPUT_MESSAGE);
        RandomMoveRule randomMoveRule = new RandomMoveRule();

        return new RacingGame(carNames, roundCount, randomMoveRule);
    }

    // 레이싱 게임 진행 (자동차 리스트 생성 => RoundCount 만큼 라운드 진행)
    public void playRacingGame() {
        RacingCars racingCars = new RacingCars(CarsGenerator.generateCars(carNames));

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