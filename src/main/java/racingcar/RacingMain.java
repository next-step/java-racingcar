package racingcar;

public class RacingMain {
    public static void main(String[] args) {
        String namesOfCars = InputView.inputNamesOfCars();
        int numberOfGames = InputView.inputNumberOfGames();

        RacingGame racingGame = new RacingGame(namesOfCars, numberOfGames);
        ResultView.printGameMessage();
        while (!racingGame.isEnd()) {
            racingGame.race();
            ResultView.printResult(racingGame.getCars());
        }
        Winners winners = new Winners(racingGame.getCars());
        ResultView.printWinners(winners.getCars());
    }
}