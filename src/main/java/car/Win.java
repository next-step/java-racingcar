package car;

import java.util.ArrayList;
import java.util.List;

public class Win {
    private final List<Car> allCar;

    public Win(List<Car> allCar) {
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
            winners.add(car.carName());
        }
    }

    private int maxCarPosition() {
        int max = 0;

        for (Car car : allCarList()) {
            max = car.compareMaxPosition(max);
        }
        return max;
    }

    private List<Car> allCarList() {
        return this.allCar;
    }
}
