package racingcar;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private List<Car> cars;

    public Cars (int carNum) {
        cars = new LinkedList<>();
        IntStream.range(0, carNum).forEach(i -> cars.add(new Car()));
    }

    public Cars (Cars carsToBeCopied) {
        cars = new LinkedList<>();
        carsToBeCopied.cars.forEach(car -> this.cars.add(new Car(car)));
    }

    public Cars move(MoveRule moveRule) {
        cars.stream().forEach(car-> car.move(moveRule));
        return this;
    }

}
