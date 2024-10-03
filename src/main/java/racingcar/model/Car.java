package racingcar.model;

import racingcar.model.enums.Status;
import racingcar.util.NumberCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Car {
    private final List<Status> statuses;

    public Car() {
        this.statuses = new ArrayList<>();
    }

    public Car(final List<Status> statuses) {
        this.statuses = statuses;//NOTE: 내부에서 변경해야 하므로 여기서 불변객체를 선언하면 안됨
    }

    public static Car newInstance() {
        return new Car();
    }

    public void move(NumberCreator numberCreator) {
        this.statuses.add(numberCreator.number().status());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(statuses, car.statuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statuses);
    }

    public List<Status> currentStatus() {
        //NOTE: 외부에서는 변경할수 없으므로 여기서 불변객체로 리턴
        return Collections.unmodifiableList(this.statuses);
    }
}
