package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {

    private Cars cars;

    private int count;

    private int tryCount;

    public Racing (String input, int count) {
        String[] carNames = input.split(",");

        List<Car> values = new ArrayList<>();
        for (String carName : carNames) {
            values.add(new Car(Name.of(carName)));
        }

        this.cars = Cars.of(values);
        this.count = count;
        this.tryCount = 0;
    }

    public void startRacing() {
        cars.run();
        tryCount++;
    }

    public boolean isEnd() {
        if (tryCount < count) {
            return false;
        }

        return true;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
