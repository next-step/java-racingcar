package racingCar;

import java.util.List;
import java.util.stream.Collectors;

public class Application {


    private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String GAME_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void main(String[] args) {

        int carCount = new InputView().intInput(CAR_COUNT_QUESTION);
        int gameCount = new InputView().intInput(GAME_COUNT_QUESTION);
        List<String> result = new RacingCarGame(carCount, gameCount).play();
        new ResultView(result).printResult(RESULT_MESSAGE);

    }
}
