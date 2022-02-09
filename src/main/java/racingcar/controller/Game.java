package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.util.Message;
import racingcar.util.RandomGenerator;
import racingcar.view.OutputView;

public class Game {
    private List<Car> cars = new ArrayList<>();

    public void play() {

        System.out.println(Message.INPUT_GUIDE_MESSAGE);
        String[] carNames = InputView.getCarName();

        List<Car> cars = carInformation(carNames);

        System.out.println(Message.ASK_TRY_COUNT);
        int tryCount = InputView.getTryCount();

        System.out.println(Message.GAME_RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            moveForwardByCount();
        }

        Winner winner = new Winner(cars);
        OutputView.printWinner(winner.winnerList());
    }

    private List<Car> carInformation(String[] carNames) {
        for (String carName: carNames){
            Car carInformation = new Car(carName);
            cars.add(carInformation);
        }
        return cars;
    }

    public void moveForwardByCount() {
        RandomGenerator randomGenerator = new RandomGenerator();
        for (Car car : cars) {
            int randomNumber = randomGenerator.generateRandomNumber();
            car.moveForward(randomNumber);
            OutputView.printResult(car.getCarName(), car.getPosition());
        }
        System.out.println();
    }
}
