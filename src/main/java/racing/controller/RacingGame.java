package racing.controller;

import racing.model.Car;
import racing.model.Racing;
import racing.view.Output;

import java.util.List;

public class RacingGame {

    public void gameStart(Racing racing) {
        List<Car> carList;
        do {
            carList = racing.game();
            Output.printCarMove(carList);
        } while (!racing.endGame());
        Output.printWinner(racing.winnerCarList());
    }
}
