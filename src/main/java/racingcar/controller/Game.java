package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.util.Message;
import racingcar.util.RandomGenerator;
import racingcar.view.OutputView;

public class Game {

    public void play() {

        Cars racingCars = new Cars();

        OutputView.printMessage(Message.INPUT_GUIDE_MESSAGE);
        String[] carNames = InputView.getCarName();

        List<Car> cars = Cars.createCars(carNames);

        OutputView.printMessage(Message.ASK_TRY_COUNT);
        int tryCount = InputView.getTryCount();

        OutputView.printMessage(Message.GAME_RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            List<Car> moveCars = racingCars.moveForwardByCount(cars);
            OutputView.printResult(moveCars);
        }

        Winners winners = new Winners(cars);
        OutputView.printWinner(winners.winnerList());
    }

}
