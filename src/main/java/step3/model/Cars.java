package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(int count, TryStrategy tryStrategy) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car(tryStrategy));
        }
    }

    public void tryOnceEach() {
        cars.forEach(Car::tryOnce);
    }

    public EachTryResult getEachTryResult() {
        List<Integer> moveCountEach = getMoveCountEach();
        return new EachTryResult(moveCountEach);
    }

    private List<Integer> getMoveCountEach() {
        return cars.stream()
                .map(Car::getMoveCount)
                .collect(Collectors.toList());
    }
}
