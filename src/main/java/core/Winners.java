package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<CarName> names() {
        return cars.names();
    }

    public List<String> namesAsString() {
        return cars.namesAsString();
    }

    public int size() {
        return cars.size();
    }

    private static class CurrentWinners {
        private final List<Car> cars;
        private int position;

        private CurrentWinners(List<Car> cars) {
            this.cars = cars;
            this.position = 0;
        }

        public void compare(Car car) {
            if (car.isAhead(position)) {
                changeWinner(car);
                return;
            }
            if (car.isAtSamePosition(position)) {
                addWinner(car);
            }
        }

        public List<CarName> names() {
            return cars.stream()
                    .map(Car::getCarName)
                    .collect(Collectors.toList());
        }

        public List<String> namesAsString() {
            return cars.stream()
                    .map(Car::getCarName)
                    .map(CarName::toString)
                    .collect(Collectors.toList());
        }

        public int size() {
            return cars.size();
        }

        private void changeWinner(Car car) {
            cars.clear();
            cars.add(car);
            position = car.getPosition();
        }

        private void addWinner(Car car) {
            cars.add(car);
        }

        public List<Car> getCars() {
            return Collections.unmodifiableList(cars);
        }
    }
}
