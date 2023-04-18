package study.racingcar;

public class RacingCar {

    public static void main(String[] args) {
        racingCar();
    }

    public static void racingCar () {

        do {
            String carNamesStr = InputView.setCarNames();
            int numberOfGames = InputView.setGames();

            RacingGame game = new RacingGame(new RacingGameInputs(numberOfGames, carNamesStr));

            ResultView.startGame();

            while (!game.isOver(numberOfGames)) {
                game.moveCar();
                game.nextLap();
            }

            ResultView.winner(new GameWinner(game.getCars()).findGameWinner());
        } while (InputView.reset());

        ResultView.endGame();
    }
}
