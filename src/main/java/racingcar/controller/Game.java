package racingcar.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.User;
import racingcar.util.Message;
import racingcar.view.OutputView;

public class Game {

    public void play() {
        List<Car> carList = new ArrayList<>();
        User user = new User();

        System.out.println(Message.INPUT_GUIDE_MESSAGE);
        String[]carNames = user.getCarName();

        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i])); //car 객체 생성
        }
        System.out.println(Message.ASK_TRY_COUNT);
        int tryCount = user.getTryCount();

        System.out.println(Message.GAME_RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            moveForwardByCount(carList);
        }

        checkWinner(carList);
    }

    public void moveForwardByCount(List<Car> carList) {
        OutputView outputView = new OutputView();
        for (Car car : carList) {
            car.moveForward();
            outputView.printResult(car.getCarName(), car.getPosition());
        }
        System.out.println();
    }

    public void checkWinner(List<Car> carList) {
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
