package racinggame;

public class Game {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        RacingGame racingGame = inputView.intput();
        while(racingGame.nextRacingGame()){
            int[] cars = racingGame.move();
            resultView.print(cars);
        }

    }
}
