package step4_racingCarWithWinner;

import java.util.List;

public class Application {

    private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String CAR_NAME_QUESTION_DELIMITER = ",";
    private static final String GAME_NAME_QUESTION = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {

        String[] carNames = InputView.stringsSplitBy(CAR_NAME_QUESTION, CAR_NAME_QUESTION_DELIMITER);
        int gameCount = InputView.intInput(GAME_NAME_QUESTION);

        List<Car> result = new RacingGame(carNames, gameCount).play();

        new RacingGamePrint().printResult(result);
    }
}
