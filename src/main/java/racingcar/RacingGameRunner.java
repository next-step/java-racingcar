package racingcar;

public class RacingGameRunner {

    private final View view = new View();

    public void run() {
        String carNames = view.readCarNames();
        String count = view.readCount();

        RacingGame racingGame = new RacingGame(new Cars(carNames), count);

        String racingGameResult = racingGame.play();

        view.printResult(racingGameResult);
    }
}
