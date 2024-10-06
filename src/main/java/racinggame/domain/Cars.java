package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racinggame.domain.Car.CarDto;

public class Cars {

    private static final int DEFAULT_POSITION = 1;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        if(cars.isEmpty())throw new IllegalArgumentException("자동차가 비여 있을 수 없습니다.");
        this.cars = cars;
    }

    public static Cars of(int count) {
        return new Cars(carInitialization(count));
    }

    private static ArrayList<Car> carInitialization(int carCount) {
        assert -1 < carCount;

        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(DEFAULT_POSITION));
        }
        return cars;
    }

    public void move(int index, int capacity) {
        Car car = cars.get(index);
        car.move(capacity);
    }

    public int count() {
        return cars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public List<CarDto> result() {
        List<CarDto> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(new CarDto(car));
        }
        return result;
    }
}
