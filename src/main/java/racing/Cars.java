package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int carCount, int moveCount) {
        List<Car> cars = new ArrayList<>(); // 밖에서 변경 불가능하게 함
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(moveCount));
        }
        this.cars = cars;
    }

    public Cars move() {
        this.cars.forEach(Car::moveToFinish);
        return this;
    }

    public List<Car> values() {
        return cars;
    }

}
