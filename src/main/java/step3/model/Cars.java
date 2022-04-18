package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> values;

    public Cars(Names names, TryStrategy tryStrategy) {
        this.values = new ArrayList<>();
        for (Name name : names.getValues()) {
            Car car = new Car(name, tryStrategy);
            values.add(car);
        }
    }

    public void tryOnceEach() {
        values.forEach(Car::tryOnce);
    }

    public EachTryResult getEachTryResult() {
        List<Integer> moveCountEach = getMoveCountEach();
        return new EachTryResult(moveCountEach);
    }

    private List<Integer> getMoveCountEach() {
        return values.stream()
                .map(Car::getMoveCount)
                .collect(Collectors.toList());
    }
}
