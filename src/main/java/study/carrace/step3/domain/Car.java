package study.carrace.step3.domain;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private final CarName carName;
    private final MoveStrategy moveStrategy;
    private final CarPosition carPosition;

    public Car(String name, MoveStrategy moveStrategy) {
        this(new CarName(name), moveStrategy);
    }

    public Car(CarName name, MoveStrategy moveStrategy) {
        this(name, moveStrategy, new CarPosition());
    }

    public Car(String name, MoveStrategy moveStrategy, CarPosition position) {
        this(new CarName(name), moveStrategy, position);
    }

    public Car(CarName name, MoveStrategy moveStrategy, CarPosition position) {
        this.carName = name;
        this.moveStrategy = moveStrategy;
        this.carPosition = position;
    }

    public Car moveOrStop(int iteration) {
        return new Car(carName, moveStrategy, carPosition.addMoveStatus(moveOrStops(iteration)));
    }

    private List<Boolean> moveOrStops(int iteration) {
        return IntStream.range(0, iteration)
                .mapToObj(i -> moveStrategy.moveOrStop())
                .collect(Collectors.toList());
    }

    public long numberOfMove() {
        return carPosition.numberOfMove();
    }

    public CarName carName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(moveStrategy, car.moveStrategy) && Objects.equals(carPosition, car.carPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, moveStrategy, carPosition);
    }
}
