package racingcar.domain;

import racingcar.domain.strategyPattern.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {
    private List<Car> carList;

    public RacingCarGame(int carCount) {
        this.carList = createCarList(carCount);
    }

    public static List<Car> createCarList(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    public List<Car> playRoundsAndReturnCarList(MoveStrategy moveStrategy) {
        for (Car car : carList) {
            car.moveForward(moveStrategy);
        }
        return carList;
    }
}
