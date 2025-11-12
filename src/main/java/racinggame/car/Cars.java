package racinggame.car;

import static java.util.Collections.unmodifiableList;
import static racinggame.RandomNumberBox.getRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            Car car = Car.of();
            cars.add(car);
        }

        return new Cars(cars);
    }

    public void playPerRound() {
        for (Car car : this.cars) {
            // 아래 코드의 위치가 이곳이 어울릴까요?, 다른 방법이 있다면 키워드가 있을까요?
            int randomNumber = getRandomNumber();
            car.changePosition(randomNumber);
        }
    }

    public List<Car> getCars() {
        return unmodifiableList(cars);
    }

    int size() {
        return cars.size();
    }
}
