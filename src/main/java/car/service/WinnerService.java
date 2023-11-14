package car.service;

import car.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerService {
    private final List<Car> allCar;

    public WinnerService(List<Car> allCar) {
        this.allCar = allCar;
    }

    public List<String> winnersNameList() {
        List<Car> cars = allCarList();
        List<String> winnersName = new ArrayList<String>();

        int max = maxCarPosition();

        for (Car car : cars) {
            addWinner(car, max, winnersName);
        }

        return winnersName;
    }

    private void addWinner(Car car, int max, List<String> winners) {
        if (car.isSameMax(max)) {
            winners.add(car.getCarName());
        }
    }

    private int maxCarPosition() {
        int max = 0;

        for (Car car : allCarList()) {
            max = car.compareCarPosition(max);
        }
        return max;
    }

    private List<Car> allCarList() {
        return this.allCar;
    }
}
