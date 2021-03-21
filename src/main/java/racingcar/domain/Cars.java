package racingcar.domain;

import racingcar.service.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(Cars cars) {
        this.cars = deepCopy(cars);
    }

    public Cars(Name[] names) {
        this.cars = generateCarsName(names);
    }


    private List<Car> deepCopy(Cars cars) {
        List<Car> copiedCars = new ArrayList<>();
        for (Car car : cars.getCars()) {
            copiedCars.add(new Car(car));
        }
        return copiedCars;
    }

    private List<Car> generateCarsName(Name[] names) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
        return cars;
    }

    public void move(MoveStrategy moveStrategy) {
        for (int i = 0; i < getSize(); i++) {
            this.cars.get(i).move(moveStrategy.getIsMove());
        }
    }

    public int getSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> winners() {
        int winnerLocation = 0;
        for (Car car : this.cars) {
            if (car.bigger(winnerLocation)) {
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
}


