package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    public static final int DEFAULT_POSITION = 0;

    private final Cars cars;

    public Winners(Cars cars) {
        if (cars.isEmpty()) {
            throw new RuntimeException("한대 이상의 자동차가 필요합니다.");
        }
        this.cars = cars;
    }

    public List<Car> findWinners() {
        List<Car> winnersList = new ArrayList<>();
        int maxPosition = findMaxPosition(cars.getCars());
        cars.getCars().forEach(car -> checkAndPutWinner(winnersList,maxPosition,car));

        return winnersList;
    }

    private void checkAndPutWinner(List<Car> winners, int maxPosition, Car car) {
        if (car.hasMaxPosition(maxPosition)) {
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
