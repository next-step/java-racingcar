package step3.application.domain;

import step3.application.domain.model.vo.Driver;
import step3.application.domain.model.dto.MovementLog;
import step3.application.domain.model.vo.Position;

import java.util.Objects;

public class Car {

    private final Driver driver;
    private final Position position;
    public static final int INIT_LOCATION = 0;

    public Car(String name) {
        this(name, INIT_LOCATION);
    }

    public Car(String  name, int position) {
        this(new Driver(name), new Position(position));
    }

    public Car(Driver driver, Position position) {
        this.driver = driver;
        this.position = position;
    }

    public MovementLog move(boolean canMove) {
        return this.driver.logNameAndPosition(this.position.add(canMove)) ;
    }

    public int passHigher(int number) {
        return this.position.compareMax(number);
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position.isMax(maxPosition);
    }

    public boolean isBest(String name) {
        return this.driver.isSameAs(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(driver, car.driver) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, position);
    }
}