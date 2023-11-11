package step4.domain;

import step4.helper.NumberUtil;
import step4.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final List<Car> cars;
    private final int round;

    public Racing(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public List<Car> start() {
        System.out.println("실행 결과");
        for (int i = 0; i < this.round; i++) {
            startRound();
            ResultView.print(cars);
        }

        return this.judgeWinners(cars);
    }

    public List<Car> judgeWinners(List<Car> cars) {
        int maxForwardCount = getMaxForwardCount(cars);
        return getMaxForwardCountCar(cars, maxForwardCount);
    }

    private void startRound() {
        for (Car car : cars) {
            car.move(NumberUtil.createRandomNumber());
        }
    }

    private List<Car> getMaxForwardCountCar(List<Car> cars, int value) {
        return cars.stream()
                .filter((car) -> car.equalForwardCount(value))
                .collect(Collectors.toList());
    }

    private int getMaxForwardCount(List<Car> cars) {
        int value = 0;
        for (Car car : cars) {
            value = car.graterThanForwardCount(value);
        }
        return value;
    }
}
