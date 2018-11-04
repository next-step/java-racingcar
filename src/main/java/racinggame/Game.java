package racinggame;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame(InputView.inpputCarName(), InputView.inputTryCnt());
        while(racingGame.nextRacingGame()){
            List<Car> cars = racingGame.move();
            resultView.print(cars);
        }

    }
}
