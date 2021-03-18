package racing.domain;

import racing.utils.RandomUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private final List<Car> carList;

    public Cars(String[] carNames) {
        this(Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

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
            car.tryMove(RandomUtil::carRandomValue);
        }
    }

    public List<Car> deepCopyToList() {
        return carList.stream()
                .map(Car::clone)
                .collect(Collectors.toList());
    }
}
