package racingGame.model.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String CAR_COUNT_ERROR_MESSAGE = "최소 2대 이상은 입력해주세요!";

    private static final int MINIMUM_CAR_COUNT = 2;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarCount(cars.size());
        this.cars = cars;
    }

    public static Cars createCars(int carCount) {
        validateCarCount(carCount);
        List<Car> cars = new ArrayList<>();
        for (int i = 0 ; i < carCount ; i++) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }

    public static Cars toCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(0, name));
        }
        return new Cars(cars);
    }

    public Cars clone() {
        List<Car> newCars = new ArrayList<>();
        for (Car car : this.cars) {
            newCars.add(car.clone());
        }
        return new Cars(newCars);
    }

    public List<Car> getCars() {
        return new ArrayList<>(this.cars);
    }

    private static void validateCarCount(int carCount) {
        if (carCount < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE);
        }
    }

    public int getMaxPosition() {
        int position = 0;
        for (Car car : this.cars) {
            position = car.getGreaterPosition(position);
        }
        return position;
    }

    public List<Car> findCarsWithSamePosition(int position) {
        List<Car> findCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.isSamePosition(position)) {
                findCars.add(car.clone());
            }
        }
        return findCars;
    }
}
