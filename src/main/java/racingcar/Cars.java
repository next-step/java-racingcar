package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private List<Car> cars;

    public Cars(int carCount) {
        makeCars(carCount);
    }

    public List<Car> carList() {
        return Collections.unmodifiableList(cars);
    }

    public void makeCars(int carCount) {
        cars = Stream.generate(() -> new Car())
                .limit(carCount)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(car -> {
            int random = RacingGame.randomNumber();
            car.move(random);
        });
    }
}
