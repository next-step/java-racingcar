package racing.domain.fuel;

@FunctionalInterface
public interface Fuel {
    int MIN_VALUE = 0;

    int MOVABLE_VALUE = 4;

    int MAX_VALUE = 9;

    boolean isMovable();
}
