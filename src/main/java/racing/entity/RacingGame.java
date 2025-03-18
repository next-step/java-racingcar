package racing.entity;

import racing.message.GameMessage;
import racing.rule.RandomMoveRule;
import racing.view.RacingGameInputView;
import racing.view.RacingGameOutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final RacingCars racingCars;
    private final int roundCount;
    private final RandomMoveRule randomMoveRule;

    private int maxPosition;

    private RacingGame(RacingCars racingCars, int roundCount, RandomMoveRule randomMoveRule) {
        this.racingCars = racingCars;
        this.roundCount = roundCount;
        this.randomMoveRule = randomMoveRule;
    }

    // 레이싱 게임 준비
    public static RacingGame readyRacingGame() {
        RacingCars racingCars = RacingGameInputView.getCarsInput(GameMessage.CAR_NAME_INPUT_MESSAGE);
        int roundCount = RacingGameInputView.getRoundCountInput(GameMessage.ATTEMPT_COUNT_INPUT_MESSAGE);
        RandomMoveRule randomMoveRule = new RandomMoveRule();

        return new RacingGame(racingCars, roundCount, randomMoveRule);
    }

    // 레이싱 게임 진행 (자동차 리스트 생성 => RoundCount 만큼 라운드 진행)
    public void playRacingGame() {
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
                updateMaxPosition(car.getPosition());
            }
        }
    }

    // 레이싱 게임 우승자 발표 (우승자 1명 이상 가능)
    public void announceRacingGameWinners() {
        RacingGameOutputView.printRacingGameWinners(getWinners(racingCars));
    }

    private void updateMaxPosition(int position) {
        maxPosition = Math.max(maxPosition, position);
    }

    private List<String> getWinners(RacingCars racingCars) {
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
}