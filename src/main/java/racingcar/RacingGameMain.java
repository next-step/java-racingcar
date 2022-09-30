package racingcar;

public class RacingGameMain {

    public static void main(String[] args) {
        RacingGameCondition condition = InputView.inputRacingCarGameCondition();
        RacingGame game = RacingGameFactory.make(condition);
        game.run();
        ResultView.printRacingGameLogs(game.getGameLogs());
    }
}
