package racingcar.random;

import racingcar.car.Car;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GenerateRandom {
    public static List<Car> moveCarForward(List<Car> cars) {
        Random random = new Random();
        return cars.stream().peek(car -> car.setStatus(random.nextInt(10) > 3 ? car.getStatus() + 1 : car.getStatus())).collect(Collectors.toList());
    }
}
