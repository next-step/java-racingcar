package racingcar.controller;

import java.util.ArrayList;
import java.util.Comparator;
import racingcar.model.Car;
import racingcar.model.User;
import racingcar.util.Message;
import racingcar.util.RandomGenerator;
import racingcar.view.OutputView;

public class Game {

    public void play() {
        ArrayList<Car> carList = new ArrayList<>();
        User user = new User();

        System.out.println(Message.INPUT_GUIDE_MESSAGE);
        String[] carNames = user.getCarName();
        System.out.println(Message.ASK_TRY_COUNT);
        int tryCount = user.getTryCount();

        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i])); //car 객체 생성
        }
        System.out.println(Message.GAME_RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            moveForwardByCount(carList);
        }

        checkWinner(carList);
    }

    public void moveForwardByCount(ArrayList<Car> carList) {
        RandomGenerator randomGenerator = new RandomGenerator();
        OutputView outputView = new OutputView();
        for (Car car : carList) {
            int randomNumber = randomGenerator.generateRandomNumber();
            car.moveForward(randomNumber);
            outputView.printResult(car.getCarName(), car.getPosition());
        }
        System.out.println();
    }

    public void checkWinner(ArrayList<Car> carList) {
        ArrayList<String> winnerList = new ArrayList<>();
        OutputView outputView = new OutputView();
        int maxPosition = 0;
        for (Car car : carList) {
            if (car.getPosition().length() > maxPosition) {
                maxPosition = car.getPosition().length();
            }
        }
        for (Car car : carList) {
            if (car.getPosition().length() == maxPosition) {
                winnerList.add(car.getCarName());
            }
        }
        outputView.printWinner(winnerList);
    }
}
