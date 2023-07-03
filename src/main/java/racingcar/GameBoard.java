package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {

    private final List<Car> cars;
    private final int tryCount;

    public GameBoard(List<String> carNames, int tryCount) {
        cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.tryCount = tryCount;
    }

    public GameBoard(List<String> carNames, int tryCount, List<Random> randoms) {
        cars = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(carNames.get(i), randoms.get(i)));
        }
        this.tryCount = tryCount;
    }

    public void run(int tryCount) {
        cars.forEach(Car::move);
        if (this.tryCount == tryCount) {
            getWinnerNames();
        }
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        int maxIndex = 0;
        for (Car car : cars) {
            maxIndex = Math.max(car.getIndex(), maxIndex);
        }
        for (Car car : cars) {
            if (car.getIndex() == maxIndex) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
