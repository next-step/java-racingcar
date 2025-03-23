package step5.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }
    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move(List<Integer> randomNums) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int random = randomNums.get(i);
            car.move(random);
        }
    }

    public List<Car> winners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = findWinners(maxPosition);

        if (winners.isEmpty()) {
            throw new RuntimeException("우승자가 존재하지 않습니다.");
        }

        return winners;
    }

    private List<Car> findWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.isSame(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxNum = 0;
        for (Car car : cars) {
            maxNum = car.maxPosition(maxNum);
        }
        return maxNum;
    }
}
