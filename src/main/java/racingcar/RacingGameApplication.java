package racingcar;

public class RacingGameApplication {

    private static final int RANDOM_RANGE = 10;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Cars cars = Cars.fromNames(inputView.readCarNames());
        int tryCount = inputView.readTryCount();

        RacingGame game = new RacingGame(cars, tryCount, new RandomNumberGenerator(RANDOM_RANGE));
        game.race();
        ResultView.viewResult(game.getRaceResult());
    }
}
