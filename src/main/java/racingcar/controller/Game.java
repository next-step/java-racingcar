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
    private List<Car> carList = new ArrayList<>();

    public void play() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        System.out.println(Message.INPUT_GUIDE_MESSAGE);
        String[] carNames = inputView.getCarName();

        carList = carInformation(carNames);

        System.out.println(Message.ASK_TRY_COUNT);
        int tryCount = inputView.getTryCount();

        System.out.println(Message.GAME_RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            moveForwardByCount();
        }

        Winner winner = new Winner(carList);
        outputView.printWinner(winner.winnerList());
    }

    private List<Car> carInformation(String[] carNames) {
        for (String carName: carNames){
            Car carInformation = new Car(carName);
            carList.add(carInformation);
        }
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    public void moveForwardByCount() {
        RandomGenerator randomGenerator = new RandomGenerator();
        OutputView outputView = new OutputView();
        for (Car car : carList) {
            int randomNumber = randomGenerator.generateRandomNumber();
            car.moveForward(randomNumber);
            outputView.printResult(car.getCarName(), car.getPosition());
        }
        System.out.println();
    }
}
