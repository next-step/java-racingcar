package step3;

public class GameLauncher {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        String namesOfCars = InputView.getNameOfCars();
        int count = InputView.getCount();
        ResultView.printResultMessage();

        racingGame.preparingGame(namesOfCars, count);
        for (int i = 0; i < count; i++) {
            ResultView.printEachResult(racingGame.race());
        }
    }

}
