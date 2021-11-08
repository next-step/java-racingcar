package racingcar.step4.domain;

import racingcar.step4.move.Moving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cars {

    private static final int COUNT_OF_CAR_MIN_NUM = 1;

    private List<Car> cars = new ArrayList<>();

    public Cars(Car ...car) {
        cars = Arrays.asList(car);
    }

    public Cars(String[] carName, int countOfCar) {
        countOfCarNameCheck(carName.length, countOfCar);
        createCars(carName, countOfCar);
    }

    public void moveCars(Moving moving) {
        for (Car car : cars) {
            car.move(moving);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    private void createCars(String[] split, int countOfCar) {
        for (int i = 0; i < countOfCar; i++) {
            cars.add(new Car(split[i].trim()));
        }
    }

    private static void countOfCarNameCheck(int length, int countOfCar) {
        if (length != countOfCar || countOfCar < COUNT_OF_CAR_MIN_NUM) {
            throw new IllegalArgumentException("자동차 이름수와 자동차 대수가 맞아야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public int getMaxPosition() {
        int max = 0;
        for (Car c : cars) {
            if (c.getPosition() > max) {
                max = c.getPosition();
            }
        }
        return max;
    }
}
