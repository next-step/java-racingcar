package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        Map<String, Integer> moveCountEach = getMoveCountEach();
        return new EachTryResult(moveCountEach);
    }

    private Map<String, Integer> getMoveCountEach() {
        return values.stream()
                .collect(Collectors.toMap(Car::getName, Car::getMoveCount));
    }
}
