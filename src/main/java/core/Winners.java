package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private final CurrentWinners cars;

    private Winners(CurrentWinners cars) {
        this.cars = cars;
    }

    public static Winners decideWinners(Cars cars) {
        CurrentWinners currentWinners = new CurrentWinners(new ArrayList<>());
        for (Car car : cars.getCars()) {
            currentWinners.compare(car);
        }
        return new Winners(currentWinners);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    private static class CurrentWinners {
        private final List<Car> cars;
        private int position;

        private CurrentWinners(List<Car> cars) {
            this.cars = cars;
            this.position = 0;
        }

        public void compare(Car car) {
            if (isBehind(car)) {
                changeWinner(car);
                return;
            }
            if (isAtSamePosition(car)) {
                addWinner(car);
            }
        }

        private void changeWinner(Car car) {
            cars.clear();
            cars.add(car);
            position = car.getPosition();
        }

        private void addWinner(Car car) {
            cars.add(car);
        }

        private boolean isBehind(Car car) {
            return position < car.getPosition();
        }

        private boolean isAtSamePosition(Car car) {
            return position == car.getPosition();
        }

        public List<Car> getCars() {
            return Collections.unmodifiableList(cars);
        }
    }
}
