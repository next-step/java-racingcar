package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

import static racingcar.model.CarRace.moveCar;

public class RacingCarController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carNum = inputView.inputCarNumber();
        int tryNum = inputView.inputTryNumber();

        CarList carList = new CarList();
        List<Car> cars = carList.addCar(carNum);

        ResultView resultView = new ResultView();
        resultView.showResultMessage();

        for(int i = 0; i < tryNum; i++){
            cars = moveCar(cars);
            resultView.Result(cars);
        }
    }

}
