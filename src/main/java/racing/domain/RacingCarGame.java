package racing.domain;

import racing.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private List<Car> cars;

    public RacingCarGame() {
    }

    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> createCars(String[] names) {
        cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public List<Car> startRacing(int round) {
        for (int i = 0; i < round; i++) {
            startRound();

            System.out.println();
        }

        return cars;
    }

    public void startRound() {
        for (Car car : cars) {
            System.out.print(car.getName() + ": ");

            int moveDistance = car.move();

            ConsoleView.viewCarMoveInfo(moveDistance);

            System.out.println();
        }
    }
}
