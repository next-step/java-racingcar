package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerChecker {

    private Cars cars;

    public WinnerChecker(Cars cars) {
        if(cars.getCarsSize()<1){
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

    private void checkAndPutWinner(List<Car> winners, int maxPosition, Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }

    private int findMaxPosition(List<Car> carList) {
        int maxPosition = -1;
        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
