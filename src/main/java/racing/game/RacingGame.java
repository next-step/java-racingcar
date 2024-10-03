package racing.game;

import racing.car.CarFactory;
import racing.car.Cars;
import racing.view.InputView;


public class RacingGame {

    public static void main(String[] args) {
        InputView input = new InputView();
        int carNumber = input.carInput();
        int count = input.cntInput();

        racingCycle(CarFactory.makeCar(carNumber), count);
    }

    /**
     * 주어진 사이클 동안 레이싱하는 기능
     */
    private static void racingCycle(Cars cars, int count) {
        RacingCalculator calculator = new RacingCalculator();
        while (count > 0) {
            count--;
            cars.carGoAndStop(calculator);
        }
    }


}
