package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.wrapper.CarNumber;
import racingcar.model.wrapper.MovementNumber;
import racingcar.util.PrintUtil;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    public static void play() {
        InputView inputView = new InputView(new Scanner(System.in));
        CarNumber carNumber = new CarNumber(inputView.carNumber());
        MovementNumber movementNumber = new MovementNumber(inputView.movement());

        Cars cars = createCars(carNumber);
        StringBuilder result = new StringBuilder();
        for (int index = 0; movementNumber.isGreaterThan(index); index++) {
            cars.moveAllByNumberCreator(new RandomNumberGenerator());
            result.append(PrintUtil.result(cars));
        }

        ResultView resultView = new ResultView();
        resultView.print(result.toString());

    }

    private static Cars createCars(CarNumber carSize) {
        List<Car> carList = new ArrayList<>();
        for (int index = 0; carSize.isGreaterThan(index); index++) {
            carList.add(new Car());
        }
        return new Cars(carList);
    }
}
