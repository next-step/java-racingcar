package step4;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step4.RacingCarUi.resultPrint;

public class RacingCarGame {
    private final Random random = new Random();
    private static final int BOUND = 10;
    private static final int MAX_CAR_NAME_NUMBER = 5;

    public List<Car> start(String[] carNames) {
        carNameMaxValid(carNames);
        return car(carNames);
    }

    private List<Car> car(String[] racingCars) {
        return Arrays.stream(racingCars)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int getRandom() {
        return random.nextInt(BOUND);
    }

    public void carMove(int numberOfMove, List<Car> cars) {
        IntStream.range(0, numberOfMove)
                .mapToObj(i -> cars)
                .forEach(this::carMove);
    }

    private void carMove(List<Car> cars) {
        cars.forEach(car -> car.move(getRandom()));
        resultPrint(cars);
    }

    private void carNameMaxValid(String[] carNames) {
        if (carNames.length > MAX_CAR_NAME_NUMBER) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과 할 수 없습니다.");
        }
    }
}
