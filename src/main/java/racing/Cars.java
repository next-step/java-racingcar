package racing;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public Winners getWinners() {
        int maxPosition = maxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.samePosition(maxPosition))
                .collect(Collectors.toList());
        return new Winners(winners);
    }

    private int maxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

}
