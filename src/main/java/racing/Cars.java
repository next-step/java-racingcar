package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinner() {
        Long maxPosition = getMaxPosition();
        return generateWinnerList(maxPosition);
    }

    private List<Car> generateWinnerList(Long maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(maxPosition, winners, car);
        }
        return winners;
    }

    private void addWinner(Long maxPosition, List<Car> winners, Car car) {
        if (car.isWinner(maxPosition)) {
            winners.add(car);
        }
    }

    private Long getMaxPosition() {
        Long maxPosition = 0L;
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<Car> forward() {
        for (Car car : cars) {
            car.forward(new RandomMovingStrategy(new Random()));
        }
        return cars;
    }
}
