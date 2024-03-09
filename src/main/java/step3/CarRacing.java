package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars;

    public CarRacing(int number, MoveStrategy moveStrategy) {
        cars = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            cars.add(new Car(moveStrategy));
        }
    }

    public void racingStart(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.moveForwardOnChance();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
