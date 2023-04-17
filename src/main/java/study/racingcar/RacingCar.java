package study.racingcar;

public class RacingCar {

    public static void main(String[] args) {
        racingCar();
    }

    public static void racingCar () {

        do {
            String carNamesStr = InputView.setCarNames();
            int numberOfGames = InputView.setGames();

            new RacingGame(new RacingGameInputs(numberOfGames, carNamesStr)).gameStart();
        } while (InputView.reset());

        ResultView.endGame();
    }
}
