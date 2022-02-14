package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.util.Message;
import racingcar.util.RandomGenerator;
import racingcar.view.OutputView;

public class Game {

    private List<Car> cars;

    public void play() {

        OutputView.printMessage(Message.INPUT_GUIDE_MESSAGE);
        String[] carNames = InputView.getCarName();

        cars = new Cars(carNames).getRacingCars();

        OutputView.printMessage(Message.ASK_TRY_COUNT);
        int tryCount = InputView.getTryCount();

        OutputView.printMessage(Message.GAME_RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            moveForwardByCount();
        }

        Winners winners = new Winners(cars);
        OutputView.printWinner(winners.winnerList());
    }

    public void moveForwardByCount() {
        RandomGenerator randomGenerator = new RandomGenerator();
        for (Car car : cars) {
            int randomNumber = randomGenerator.generateRandomNumber();
            car.moveForward(randomNumber);
            OutputView.printResult(car);
        }
        System.out.println();
    }
}
