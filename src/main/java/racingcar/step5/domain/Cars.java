package racingcar.step5.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    //테스트 코드를 위한 메서드
    public Cars(Car... car) {
        cars = Arrays.asList(car);
    }

    public Cars(String[] carName) {
        createCars(carName);
    }

    public void moveCars(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .filter(this::moreThanZero)
                .max()
                .orElse(0);
    }

    private boolean moreThanZero(int num) {
        return num > 0;
    }

    private void createCars(String[] split) {
        Arrays.stream(split)
                .forEach(name -> cars.add(new Car(name.trim())));
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

}
