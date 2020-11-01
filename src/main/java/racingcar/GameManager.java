package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManager {

    private final Discriminator discriminator;

    public GameManager(Discriminator discriminator) {
        this.discriminator = discriminator;
    }

    public List<Car> createCars(int carNum) {
        return IntStream.range(0, carNum)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    public void move(List<Car> cars) {
        cars.stream().forEach(car -> move(car));
    }

    private void move(Car c) {
        if (discriminator.discriminate())
            c.move();
    }
}
