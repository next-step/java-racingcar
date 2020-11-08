package step04;

import step03.strategy.RandomMoveStrategy;

public class Main {
    public static void main(String[] args) {
        final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        final String carNames = InputView.readString(INPUT_CAR_NAMES_MESSAGE);

        final String INPUT_NUMBER_OF_MOVES_MESSAGE = "시도할 회수는 몇회인가요?";
        final int numberOfMoves = InputView.readInteger(INPUT_NUMBER_OF_MOVES_MESSAGE);

        final int position = 1;
        final String carKind = "-";

        Cars cars = Cars.of(carNames, position, RandomMoveStrategy.of());
        Race race = Race.of(numberOfMoves, cars);
        ResultView resultView = ResultView.of(carKind);

        race.operate(resultView);
    }
}
