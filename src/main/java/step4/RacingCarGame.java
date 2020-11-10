package step4;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {
    private final Random random = new Random();
    private static final int BOUND = 10;
    private static final int MAX_CAR_NAME_NUMBER = 5;

    public void start(int numberOfMove, String carNames) {
        car(numberOfMove, setCars(carNames));
    }

    public void car(int move, String[] racingCars) {
        List<Car> cars = Arrays.stream(racingCars)
                .map(Car::new)
                .collect(Collectors.toList());
        carMove(move, cars);
    }

    public int getRandom() {
        return random.nextInt(BOUND);
    }

    public void carMove(int move, List<Car> cars) {
        IntStream.range(0, move)
                .mapToObj(i -> cars)
                .forEach(this::carMove);

        RacingCarUi.finalWinner(cars);
    }

    public void carMove(List<Car> cars) {
        cars.forEach(car -> car.move(getRandom()));
        RacingCarUi.resultPrint(cars);
    }

    public String[] setCars(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException("경주할 자동차 이름이 비어있습니다.");
        }
        String[] racers = carName.split(",");
        if (racers.length > MAX_CAR_NAME_NUMBER) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과 할 수 없습니다.");
        }
        return racers;
    }
}
