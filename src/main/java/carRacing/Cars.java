package carRacing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private void comparePosition(List<Car> winners, Car car) {
        int curMaxPosition = winners.get(0).getPosition();
        int comparePosition = car.getPosition();

        if (curMaxPosition < comparePosition) {
            winners.clear();
            winners.add(car);
            return;
        }

        if (curMaxPosition == comparePosition) {
            winners.add(car);
        }
    }

    public void move(CarMovingStrategy strategy) {
        for (Car car : cars) {
            car.go(strategy);
            ResultView.printPosition(car);
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(0));

        for (int i = 1; i < cars.size(); i++) {
            comparePosition(winners, cars.get(i));
        }

        return winners;
    }
}
