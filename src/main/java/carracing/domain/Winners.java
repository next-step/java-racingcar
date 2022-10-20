package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    public static final int DEFAULT_POSITION = 0;
    private final Cars cars;

    public Winners(Cars cars) {
        if (cars.getCarsSize() < 1) {
            throw new RuntimeException("한대 이상의 자동차가 필요합니다.");
        }

        this.cars = cars;
    }

    public List<Car> findWinners() {

        List<Car> winnersList = new ArrayList<>();
        int maxPosition = findMaxPosition(cars.getCars());

        for (Car car : cars.getCars()) {
            checkAndPutWinner(winnersList, maxPosition, car);
        }
        return winnersList;
    }

    public static List<Car> findWinners(List<Car> cars) {
        return findWinners(cars, getMaxPosition(cars));
    }

    private static List<Car> findWinners(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.isMaxPosition(maxPosition)){
                winners.add(car);
            }
        }
        return winners;
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    private void checkAndPutWinner(List<Car> winners, int maxPosition, Car car) {
        if (car.isMaxPosition(maxPosition)) {
            winners.add(car);
        }
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }
}
