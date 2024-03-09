package step3;

import step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars;

    public CarRacing(int carNumbers, MoveStrategy moveStrategy) {
        cars = new ArrayList<>();
        for (int i = 0; i < carNumbers; i++) {
            cars.add(new Car(moveStrategy));
        }
    }

    public void racingStart(int attemptCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            moveCars();
            ResultView.displayCurrentCarsLocation(cars);
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
