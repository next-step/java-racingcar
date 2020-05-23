package racing;

import racing.view.InputView;

import java.util.List;

public class RacingGameStart {

    public static void main(String[] args) {
        int cars = InputView.inputCar();
        int times = InputView.inputTime();

        RacingCars racingCars = new RacingCars(cars);
        List<Car> carList = racingCars.prepareCars();

        for (int i = 0; i < cars; i++) {
           carList.get(i).move(new CarForwardBehavior());
           System.out.println(carList.get(i).getPosition());
        }


    }
}
