package game.racing;

import game.racing.domain.Car;
import game.racing.domain.CarFactory;
import game.racing.domain.GameResult;
import game.racing.domain.RacingGame;
import game.racing.view.InputView;
import game.racing.view.ResultView;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        List<Car> cars = CarFactory.createDefaultShapeCars(carNames.split(","));
        RacingGame racingGame = new RacingGame(cars);
        GameResult result = null;
        for (int i = 0; i < tryNo; i++) {
            result = racingGame.move();
            ResultView.print(result);
        }
        ResultView.printWinner(result);
    }

}
