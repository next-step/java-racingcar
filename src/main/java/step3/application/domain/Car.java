package step3.application.domain;

import step3.application.domain.model.Driver;
import step3.application.domain.model.MovementLog;
import step3.application.domain.model.Position;

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
}