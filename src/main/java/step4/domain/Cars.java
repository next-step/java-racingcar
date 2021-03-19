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

    public static Cars from(final String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다.");
        }
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",")) {
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
        int maxPosition = 0;
        for (int i = 0; i < cars.size() - 1; i++) {
            maxPosition = Math.max(cars.get(i).getPosition(), cars.get(i + 1).getPosition());
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
