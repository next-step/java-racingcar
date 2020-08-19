package carracing.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Winner {
    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    protected String getWinner() {
        int maxPosition = getMaxPosition();
        return cars.stream().filter(car -> maxPosition <= car.getPosition()).flatMap(car -> Stream.of(car.getCarName())).collect(Collectors.joining(","));
    }
    private int getMaxPosition() {
        return cars.stream().flatMapToInt(car -> IntStream.of(car.getPosition())).max().getAsInt();
    }
}
