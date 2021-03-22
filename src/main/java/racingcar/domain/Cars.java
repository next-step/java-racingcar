package racingcar.domain;

import racingcar.service.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(Cars cars) {
        this.cars = deepCopy(cars);
    }

    public Cars(Name[] names) {
        this.cars = generateCars(names);
    }

    public Cars(int[] locations, Name[] names) {
        this.cars = generateCars(locations, names);
    }

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void move(MoveStrategy moveStrategy) {
        for (int i = 0; i < getSize(); i++) {
            this.cars.get(i).move(moveStrategy.getIsMove());
        }
    }


    public List<Car> getCars() {
        return cars;
    }

    public List<Car> winners() {
        int winnerLocation = 0;
        for (Car car : this.cars) {
            if (car.win(winnerLocation)) {
                winnerLocation = car.getCurrentLocation();
            }
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : this.cars) {
            if (winnerLocation == car.getCurrentLocation()) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getSize() {
        return cars.size();
    }

    private List<Car> deepCopy(Cars cars) {
        List<Car> copiedCars = new ArrayList<>();
        for (Car car : cars.getCars()) {
            copiedCars.add(new Car(car));
        }
        return copiedCars;
    }

    private List<Car> generateCars(Name[] names) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
        return cars;
    }

    private List<Car> generateCars(int[] locations, Name[] names) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(locations[i], names[i]));
        }
        return cars;
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


