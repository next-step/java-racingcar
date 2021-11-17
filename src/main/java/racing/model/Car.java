package racing.model;

import javax.naming.Name;
import java.util.Optional;
import java.util.function.Predicate;

/*
 *
 * Car
 *
 * @version 1.0.0
 *
 * 2021-11-12
 *
 * Copyright tnals1422
 */
public class Car {

    private static final int CRITERIA = 4;
    private final CarName name;
    private final CarPosition position;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int position) {
        this.name = new CarName(carName);
        this.position = new CarPosition(position);
    }

    public void moveOnSatisfiedCondition(int condition) {
        Optional.of(condition)
                .filter(isForward())
                .ifPresent(x -> position.forward());
    }

    private Predicate<Integer> isForward() {
        return number -> number >= CRITERIA;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getCarName();
    }
}
