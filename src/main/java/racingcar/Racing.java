package racingcar;

import java.util.*;

public class Racing {

    private final int carsNum;
    private final int gameCount;
    private List<Car> cars;

    public Racing(int carsNum, int gameCount) {
        this.carsNum = carsNum;
        this.gameCount = gameCount;
        this.cars = createCars(carsNum);
    }

    private List<Car> createCars(int carsNum) {
        List<Car> result = new ArrayList<>();
        for (int i = 0; i < carsNum; i++) {
            result.add(new Car());
        }
        return result;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
