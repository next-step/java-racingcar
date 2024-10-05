package racingcar.model;

import racingcar.model.enums.Status;
import racingcar.model.wrapper.CarName;
import racingcar.util.NumberCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static racingcar.model.enums.Status.FORWARD;


public class Car {
    private final CarName carName;
    private final List<Status> statuses;

    public Car(CarName carName) {
        this.carName = carName;
        this.statuses = new ArrayList<>();
    }

    public Car(CarName carName, List<Status> statuses) {
        this.carName = carName;
        this.statuses = statuses;//NOTE: 내부에서 변경해야 하므로 여기서 불변객체를 선언하면 안됨
    }

    public static Car newInstance(final CarName carName) {
        return new Car(carName);
    }

    public void move(NumberCreator numberCreator) {
        this.statuses.add(numberCreator.number().status());
    }

    public List<Status> currentStatus() {
        //NOTE: 외부에서는 변경할수 없으므로 여기서 불변객체로 리턴
        return Collections.unmodifiableList(this.statuses);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(statuses, car.statuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, statuses);
    }

    public CarName carName() {
        return this.carName;
    }

    public int currentForwardCount() {
        long count = this.statuses
                .stream()
                .filter(status -> status.equals(FORWARD))
                .count();
        return Long.valueOf(count).intValue();
    }
}
