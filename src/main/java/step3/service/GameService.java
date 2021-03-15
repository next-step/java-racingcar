package step3.service;

import step3.domain.Car;
import step3.util.Constant;
import step3.util.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameService {

    private GameService() { }

    public static GameService newInstance() {
        return new GameService();
    }

    public List<Car> makeCars(int numberOfCars) {
        return IntStream.range(Constant.ZERO, numberOfCars)
                .mapToObj((int value) -> new Car())
                .collect(Collectors.toList());
    }

    public List<Car> moveCars(List<Car> cars) {
        return cars.stream()
                .peek(car -> car.move(RandomUtil.getRandomIntBetweenZeroToNine()))
                .collect(Collectors.toList());
    }
}
