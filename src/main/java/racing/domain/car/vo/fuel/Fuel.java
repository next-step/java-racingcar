package racing.domain.car.vo.fuel;

@FunctionalInterface
public interface Fuel {
    int MIN_VALUE = 0;

    int MAX_VALUE = 9;

    int value();
}
