package racingcar.domain.model;

import java.util.Objects;
import racingcar.domain.strategy.MoveStrategy;

public class Car {

    private final Name name;
    private MoveHistory moveHistory;

    private Car(String name) {
        this.name = Name.from(name);
        this.moveHistory = MoveHistory.create();
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void move(MoveStrategy moveStrategy) {
        moveHistory.addHistory(moveStrategy.isMove());
    }

    public long getHistorySuccessCount() {
        return moveHistory.getSuccessCount();
    }

    public long getHistorySuccessCount(int toIndex) {
        return moveHistory.getSuccessCount(toIndex);
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(moveHistory, car.moveHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moveHistory);
    }
}
