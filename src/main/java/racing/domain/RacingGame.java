package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racing.utils.RandomNumber.makeOneRandomNumber;

public class RacingGame {
    public static final String SEPARATOR = ",";

    List<Car> cars;

    public RacingGame(String[] carNameArray) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
        this.cars = cars;
    }

    //현재는 안쓰지만 미리 만들어놈
    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void repeatMoveCars(int count) {
        for (int i = 0; i < count; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(makeOneRandomNumber());
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
            winnerCondition = Math.max(winnerCondition,car.getMoveCount());
        }
        return winnerCondition;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}