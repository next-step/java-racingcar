package racing;

public class RacingGameMain {
    public static void main(String args[]) {

        String[] carNames = InputView.getNamesOfCars();
        int timeToTry = InputView.getTimeToTry();

        RacingGame racingGame = new RacingGame(carNames, timeToTry);
        RacingResult result = null;

        while(racingGame.isEnd()) {
            result = racingGame.race();
            ResultView.printResult(result);
        }

        ResultView.printWinners(result);

    }
}
