package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carNum = inputView.inputCarNumber();
        int tryNum = inputView.inputTryNumber();

        CarList carList = new CarList();
        List<Car> cars = carList.addCar(carNum);
    }

}
