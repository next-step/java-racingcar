package race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    private String name;

    private List<Boolean> distance = new ArrayList<>();

    public List<Boolean> getDistance() {
        return Collections.unmodifiableList(distance);
    }

    public String getName() {
        return name;
    }

    public void addDistance(MoveCondition moveCondition) {
        distance.add(moveCondition.moveOrNot());
    }

    public static Car createCar(String name, List<Boolean> distance) {
        Car car = new Car();
        car.name = name;
        car.distance = distance;
        return car;
    }


    public Car() {
    }
}
