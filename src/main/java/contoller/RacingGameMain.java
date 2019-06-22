package contoller;

import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class RacingGameMain {

    public static void main(String[] args) {
        String namesOfCar = InputView.getCarNames();
        int timeofGame = InputView.getTimeofGame();

        RacingGame racingGame = new RacingGame(namesOfCar, timeofGame);
        while(!racingGame.isEnd()) {
            racingGame.race();
            ResultView.printCars(racingGame.getCars());
        }

//        System.out.println("첫번째 자동차" + racingGame.car.get(2).getCarName()+ " : "+racingGame.car.get(2).getCarPosition());

    }
}
