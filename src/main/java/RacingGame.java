import domain.Car;
import domain.NumberUtils;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {

    private static final Integer CONDITON = 4;
    private Random random = new Random();


    public List<Car> makeCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

    public void game(List<Car> cars) {
        cars.forEach(car -> {
            car.moveWithConditon(random.nextInt(10), CONDITON);
        });
    }

    public List<Car> getWinners(List<Car> cars) {
        int max = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();

        return cars.stream().filter(
                car -> max == car.getDistance()
        ).collect(Collectors.toList());
    }
}
