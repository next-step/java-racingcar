package racing.domain;

import java.util.ArrayList;
import java.util.List;

import static racing.utils.RandomNumber.makeOneRandomNumber;

public class RacingGame {
    public static String SEPARATOR = ",";

    List<Car> cars = new ArrayList<>();

    public void makeCars(String[] carNameArray) {
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }

    public void repeatMoveCars(int count) {
        for (int i = 0; i < count; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(makeOneRandomNumber());
        }
    }

    public List<String> findWinner() {
        List<String> winnerList = new ArrayList<>();
        int winnerCondition = findWinnerCondition();
        for (Car car : cars) {
            if (car.isWinner(winnerCondition)) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private int findWinnerCondition() {
        int winnerCondition = 0;
        for (Car car : cars) {
            if (car.getMoveCount() >= winnerCondition) {
                winnerCondition = car.getMoveCount();
            }
        }
        return winnerCondition;
    }

    public List<Car> getCars() {
        return cars;
    }
}