package racinggame;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        WinnterView winnterView = new WinnterView();
        RacingGame racingGame = new RacingGame(InputView.inpputCarName(), InputView.inputTryCnt());
        while(racingGame.nextRacingGame()){
            List<Car> cars = racingGame.move();
            resultView.print(cars);
        }
        winnterView.print(racingGame.getVictorCar());

    }
}
