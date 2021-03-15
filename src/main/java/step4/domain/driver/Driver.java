package step4.domain.driver;

import step4.domain.driver.car.Car;
import step4.domain.driver.name.Name;
import step4.domain.startegy.move.MoveStrategy;

public class Driver {

    private final String UNIT = "-";
    private final String BLANK = " ";

    private Name name;
    private Car car;

    public static Driver from(Name name, Car car) {
        return new Driver(name, car);
    }

    private Driver(Name name, Car car) {
        this.name = name;
        this.car = car;
    }

    public void move(MoveStrategy moveStrategy) {
        car.move(moveStrategy);
    }

    public int getStatus() {
        return car.getStatus();
    }

}
