package racingcar.controller;

import java.util.ArrayList;
import java.util.Comparator;
import racingcar.model.Car;
import racingcar.model.User;
import racingcar.util.Message;
import racingcar.util.RandomGenerator;
import racingcar.view.OutputView;

public class Game {

    RandomGenerator randomGenerator = new RandomGenerator();
    int randomNumber = randomGenerator.generateRandomNumber();

    public void play() {
        ArrayList<String> carNameList;
        String[] carNames; //입력 받은 자동차 이름들
        int tryCount;
        ArrayList<Car> carList = new ArrayList<>(); //경주를 하는 car 모음
        User user = new User();

        System.out.println(Message.INPUT_GUIDE_MESSAGE);
        carNames = user.getCarName();
        System.out.println(Message.ASK_TRY_COUNT);
        tryCount = user.getTryCount();

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
        OutputView outputView = new OutputView();
        for (Car car : carList) {
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
