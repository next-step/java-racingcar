package racing.domain;

import java.util.ArrayList;
import java.util.List;

import static racing.utils.RandomNumber.makeOneRandomNumber;

public class RacingGame {
    public static String SEPARATOR = ",";

    public List<Car> makeCars(String[] carNameArray) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<Car> repeatMoveCars(int count, List<Car> carList) {
        for (int i = 0; i < count; i++) {
            carList = moveCars(carList);
        }
        return carList;
    }

    public List<String> findWinner(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        int winnerCondition = findWinnerCondition(carList);
        for (Car car : carList) {
            if (car.isWinner(winnerCondition)) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private List<Car> moveCars(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(makeOneRandomNumber());
        }
        return carList;
    }

    private int findWinnerCondition(List<Car> carList) {
        int winnerCondition = 0;
        for (Car car : carList) {
            if (car.getMoveCount() >= winnerCondition) {
                winnerCondition = car.getMoveCount();
            }
        }
        return winnerCondition;
    }
}