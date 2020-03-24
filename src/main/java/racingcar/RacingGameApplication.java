package racingcar;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGame game = new RacingGame(InputView.getInputData());

        ResultView.printGameResult();

        while (!game.isFinish()) {
            game.progress();

            ResultView.renderCarMovement(game.getCars());
        }
    }
}
