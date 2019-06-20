package racing;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerMaker {
    private List<Car> cars;

    public WinnerMaker(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        int max = getWinnerRecord(cars);

        return findWinners(max, cars);
    }

    private int getWinnerRecord(List<Car> cars) {
        int max = Integer.MIN_VALUE;

        for (Car car : cars) {
            int position = car.getPosition();
            if (isBigger(position, max)) {
                max = position;
            }
        }

        return max;
    }

    private List<Car> findWinners(int max, List<Car> cars) { ;
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());

        return winners;
    }

    private boolean isBigger(int original, int target) {
        return original > target;
    }
}
