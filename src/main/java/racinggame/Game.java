package racinggame;

public class Game {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame(InputView.inputCountCar(), InputView.inputTryCnt());
        while(racingGame.nextRacingGame()){
            int[] cars = racingGame.move();
            resultView.print(cars);
        }

    }
}
