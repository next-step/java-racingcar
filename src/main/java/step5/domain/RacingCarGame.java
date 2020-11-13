package step5.domain;

import step5.util.CarUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step5.view.RacingCarUi.resultPrint;

public class RacingCarGame {
    public List<Car> start(String[] carNames) {
        CarUtils.carNameMaxValid(carNames);
        return newCars(carNames);
    }

    private List<Car> newCars(String[] racingCars) {
        return Arrays.stream(racingCars)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void carMove(int numberOfMove, List<Car> cars) {
        IntStream.range(0, numberOfMove)
                .mapToObj(i -> cars)
                .forEach(this::carMove);
    }

    private void carMove(List<Car> cars) {
        cars.forEach(car -> car.move(CarUtils.getRandom()));
        resultPrint(cars);
    }
}
