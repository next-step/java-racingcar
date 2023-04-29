package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private static final String NOTICE_WINNER = "가 최종 우승했습니다.";
    private static final String SPLITTER = ",";
    private final String[] CAR_NAMES;
    private final List<Car> CARS;
    private final MovingStrategy MOVING_STRATEGY;

    public Racing(String[] CAR_NAMES, List<Car> CARS, MovingStrategy MOVING_STRATEGY) {
        this.CAR_NAMES = CAR_NAMES;
        this.CARS = CARS;
        this.MOVING_STRATEGY = MOVING_STRATEGY;
    }

    public static List<Car> create(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void race() {
        for (Car car : CARS) {
            car.move(MOVING_STRATEGY);
        }
    }

    public List<Car> getRacingCars() {
        return CARS;
    }

    public void findWinner() {
        int maxMoveCount = findMaxMoveCount(CARS);
        List<String> winners = findWinnerCarNames(CARS, maxMoveCount);
        String finalWinners = String.join(SPLITTER, winners);
        System.out.print(finalWinners + NOTICE_WINNER);
    }

    public List<String> findWinnerCarNames(List<Car> cars, int maxMoveCount) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            maxMoved(maxMoveCount, winners, car);
        }
        return winners;
    }

    public void maxMoved(int maxMoveCount, List<String> winners, Car car) {
        if (car.getMoveCount() == maxMoveCount) {
            winners.add(car.getCarName());
        }
    }

    public int findMaxMoveCount(List<Car> cars) {
        int maxMoveCount = 0;
        for (Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }
        return maxMoveCount;
    }
}
