package game.domain;

import game.util.InputView;
import game.util.ResultView;

public class GameInput {

    private static final String ASK_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final String carCount;
    private final String gameCount;

    private GameInput(String carCount, String gameCount) {
        this.carCount = carCount;
        this.gameCount = gameCount;
    }

    public static GameInput process(){
        ResultView.printPlainMessage(ASK_CAR_COUNT_MESSAGE);
        String num1 = InputView.insertValue();
        ResultView.printPlainMessage(ASK_GAME_COUNT_MESSAGE);
        String num2 = InputView.insertValue();
        return new GameInput(num1, num2);
    }

    public String getCarCount() {
        return carCount;
    }

    public String getGameCount() {
        return gameCount;
    }
}
