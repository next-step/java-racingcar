package racing.models;

import racing.utils.RandomUtil;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public Iterator<Car> iterator() {
        return carList.iterator();
    }

    @Override
    public void forEach(Consumer<? super Car> action) {
        carList.forEach(action);
    }

    @Override
    public Spliterator<Car> spliterator() {
        return carList.spliterator();
    }

    public void tryMoveAll() {
        for (Car car : carList) {
            car.tryMove(() -> RandomUtil.nextInt(Car.MAX_BOUNDARY_VALUE + 1));
        }
    }

    public List<Car> deepCopyToList() {
        return carList.stream()
                .map(Car::clone)
                .collect(Collectors.toList());
    }
}
