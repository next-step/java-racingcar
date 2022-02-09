package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.util.Message;
import racingcar.util.RandomGenerator;
import racingcar.view.OutputView;

public class Game {
    private List<Car> cars = new ArrayList<>();

    public void play() {

        System.out.println(Message.INPUT_GUIDE_MESSAGE);
        String[] carNames = InputView.getCarName();

        List<Car> cars = racingCars(carNames);

        System.out.println(Message.ASK_TRY_COUNT);
        int tryCount = InputView.getTryCount();

        System.out.println(Message.GAME_RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            moveForwardByCount();
        }

        Winners winners = new Winners(cars);
        OutputView.printWinner(winners.winnerList());
    }

    private List<Car> racingCars(String[] carNames) {
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
