package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    Cars(String[] carNames) {
        this.cars = initCars(carNames);
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
        int maxDistance = -1;
        for (Car car : snapshot.getCars()) {
            if (maxDistance == -1) {
                winners.append(car.getName());
                maxDistance = car.getDistance();
            } else if (maxDistance == car.getDistance()) {
                winners.append(", " + car.getName());
            } else if (maxDistance < car.getDistance()) {
                winners = new StringBuffer();
                winners.append(car.getName());
                maxDistance = car.getDistance();
            }
        }

        return winners.toString();
    }

    private List<Car> initCars(String[] carNames) {
        int numberOfCars = carNames.length;
        List<Car> cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(i, new Car(carNames[i]));
        }
        return cars;
    }
}
