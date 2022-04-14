package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    Cars(String[] carNameArr) {
        this.cars = initCars(carNameArr);
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    Cars move(Movable movable) {
        List<Car> carList = new ArrayList<>(cars.size());
        for (Car car : cars) {
            carList.add(car.move(movable));
        }
        return new Cars(carList);
    }

    String getWinner(Cars snapshot) {
        StringBuffer winners = new StringBuffer();
        int maxDistance = 0;
        for (Car car : snapshot.getCars()) {
            if (winners == null) {
                winners.append(car.getName());
                maxDistance = car.getDistance();
                continue;
            }

            if (car.getDistance() == maxDistance) {
                winners.append(", " + car.getName());
            }

            if (car.getDistance() > maxDistance) {
                winners = new StringBuffer();
                winners.append(car.getName());
                maxDistance = car.getDistance();
            }
        }

        return winners.toString();
    }

    private List<Car> initCars(String[] carNameArr) {
        int numberOfCars = carNameArr.length;
        List<Car> cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(i, new Car(carNameArr[i]));
        }
        return cars;
    }
}
