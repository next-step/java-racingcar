package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<Car> cars;

    private Winners(List<Car> cars) {
        this.cars = cars;
    }

    public static Winners decideWinners(Cars cars) {
        CurrentWinners currentWinners = new CurrentWinners(new ArrayList<>());
        for (Car car : cars.getCars()) {
            decideCurrentWinners(currentWinners, car);
        }
        return new Winners(currentWinners.getCars());
    }

    private static void decideCurrentWinners(CurrentWinners currentWinners, Car car) {
        if (currentWinners.isBehind(car)) {
            currentWinners.changeWinner(car);
            return;
        }
        if (currentWinners.isAtSamePosition(car)) {
            currentWinners.addWinner(car);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private static class CurrentWinners {
        private final List<Car> cars;
        private int position;

        private CurrentWinners(List<Car> cars) {
            this.cars = cars;
            this.position = 0;
        }

        public void changeWinner(Car car) {
            cars.clear();
            cars.add(car);
            position = car.getPosition();
        }

        public void addWinner(Car car) {
            cars.add(car);
        }

        public boolean isBehind(Car car) {
            return position < car.getPosition();
        }

        public boolean isAtSamePosition(Car car) {
            return position == car.getPosition();
        }

        public List<Car> getCars() {
            return Collections.unmodifiableList(cars);
        }

        public int getPosition() {
            return position;
        }
    }
}
