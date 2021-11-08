package racingcar.view;

import racingcar.RacingGame;
import racingcar.model.RacingGameRequest;
import racingcar.collection.RacingResult;

public class OutputView {
    private final static String SKID_MARK_CHARACTER = "-";
    private final static String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private final RacingGame racingGame;
    private final int countOfTry;

    public OutputView(RacingGameRequest request) {
        this.racingGame = new RacingGame(request.getCountOfCar());
        this.countOfTry = request.getCountOfTry();
    }

    public void printPlayRacing() {
        this.printExecutionResultMessage();
        for (int i = 0; i < countOfTry; i++) {
            RacingResult racingResult = racingGame.race();
            this.printCurrentPositionOfCars(racingResult);
        }
    }

    public void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printCurrentPositionOfCars(RacingResult racingResult) {
        racingResult.getPositions()
                .forEach(this::printCurrentPositionOfCar);
        System.out.println();
    }

    private void printCurrentPositionOfCar(int currentPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= currentPosition; i++) {
            stringBuilder.append(SKID_MARK_CHARACTER);
        }
        System.out.println(stringBuilder);
    }
}
