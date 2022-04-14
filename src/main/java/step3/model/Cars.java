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
        List<Integer> successCountEach = getSuccessCountEach();
        return new EachTryResult(successCountEach);
    }

    private List<Integer> getSuccessCountEach() {
        return cars.stream()
                .map(Car::getSuccessCount)
                .collect(Collectors.toList());
    }
}
