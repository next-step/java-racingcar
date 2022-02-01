package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.util.Message;
import racingcar.util.RandomGenerator;
import racingcar.view.OutputView;

public class Game {
    private List<Car> carList = new ArrayList<>();

    public void play() {
        InputView inputView = new InputView();

        System.out.println(Message.INPUT_GUIDE_MESSAGE);
        String[] carNames = inputView.getCarName();

        for (String carName:carNames) {
            Car carInformation = new Car(carName);
            carList.add(carInformation);
        }

        System.out.println(Message.ASK_TRY_COUNT);
        int tryCount = inputView.getTryCount();

        System.out.println(Message.GAME_RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            moveForwardByCount();
        }
        checkWinner();
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

    public void checkWinner() {
        OutputView outputView = new OutputView();

        int maxPosition = maximumDistance();
        ArrayList<String> winners = winnerList(maxPosition);

        outputView.printWinner(winners);
    }

    public ArrayList<String> winnerList(int maxPosition) {
        ArrayList<String> winners = new ArrayList<>();

        for (Car car : carList) {
            if (car.getPosition().length() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private int maximumDistance() {
        int maxPosition = 0;
        for (Car car : carList) {
            if (car.getPosition().length() > maxPosition) {
                maxPosition = car.getPosition().length();
            }
        }
        return maxPosition;
    }
}
