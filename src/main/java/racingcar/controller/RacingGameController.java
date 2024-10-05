package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.model.wrapper.CarName;
import racingcar.model.wrapper.MovementNumber;
import racingcar.util.PrintUtil;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class RacingGameController {

    public static void play() {
        InputView inputView = new InputView(new Scanner(System.in));
        List<CarName> carNames = CarName.convertStringToCarNames(inputView.carNames());
        MovementNumber movementNumber = new MovementNumber(inputView.movement());

        Cars cars = Cars.newInstance(carNames);
        StringBuilder result = new StringBuilder();
        for (int index = 0; movementNumber.isGreaterThan(index); index++) {
            cars.moveAllByNumberCreator(new RandomNumberGenerator());
            result.append(PrintUtil.result(cars));
        }

        ResultView resultView = new ResultView();
        resultView.printResult(result.toString());
        resultView.printWinners(PrintUtil.winners(new Winners(cars)));
    }

}