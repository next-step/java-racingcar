package racingGame.model.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String CAR_COUNT_ERROR_MESSAGE = "최소 2대 이상은 입력해주세요!";

    private static final int MINIMUM_CAR_COUNT = 2;

    private List<Car> carGroup;

    public Cars() {
        carGroup = new ArrayList<>();
    }

    public Cars(int carCount) {
        this();
        validateCarCount(carCount);
        for (int i = 0 ; i < carCount ; i++) {
            addCar();
        }
    }

    public Cars(List<Car> cars) {
        this();
        validateCarCount(cars.size());
        for (Car car : cars) {
            addCar(car);
        }
    }

    public void addCar() {
        this.carGroup.add(new Car());
    }

    public void addCar(Car car) {
        this.carGroup.add(car.clone());
    }

    public Cars clone() {
        return new Cars(this.getCarGroup());
    }

    public List<Car> getCarGroup() {
        return this.carGroup;
    }

    private void validateCarCount(int carCount) {
        if (carCount < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE);
        }
    }
}
