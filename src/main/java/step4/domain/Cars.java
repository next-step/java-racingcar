package step4.domain;

import step4.utils.RandomUtils;
import step4.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int MAX_BOUND = 10;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("경주를 진행할 자동차가 존재하지 않습니다.");
        }
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.from(name));
        }
        return new Cars(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.move(RandomUtils.getRandomNum(MAX_BOUND));
        }
    }

    public List<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(winners, car, maxPosition);
        }
        return winners;
    }

    private void addWinner(List<String> winners, final Car car, final int maxPosition) {
        if (car.getPosition() >= maxPosition) {
            winners.add(car.getName());
        }
    }

    private int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo).orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
