package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Game {
    private int carsCount;
    private int movementsCount;

    public void racingCar() {
        InputView input = new InputView();
        carsCount = input.getCarCount();
        movementsCount = input.getTryCount();
        CarList cars = new CarList(carsCount);

        ResultView resultView = new ResultView();
        for(int i = 0; i < movementsCount; i++) {
            resultView.draw(cars.move());
        }
    }
}
