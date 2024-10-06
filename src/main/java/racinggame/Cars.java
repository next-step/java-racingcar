package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(int count) {
        if (!isPositive(count)) {
            throw new IllegalArgumentException("음수를 사용 할 수 없습니다.");
        }
        return new Cars(carInitialization(count));
    }

    private static boolean isPositive(int number) {
        return 0 <= number;
    }

    private static ArrayList<Car> carInitialization(int carCount) {
        assert -1 < carCount;

        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(0));
        }
        return cars;
    }

    public void mode(int index, int capacity) {
        Car car = cars.get(index);
        car.move(capacity);
    }

    public int count(){
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
}
