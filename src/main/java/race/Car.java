package race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    private String name;

    private List<Boolean> winOrLoseLog = new ArrayList<>();

    private int distance;

    public List<Boolean> getWinOrLoseLog() {
        return Collections.unmodifiableList(winOrLoseLog);
    }

    public String getName() {
        return name;
    }

    public void addDistance(MoveCondition moveCondition) {
        boolean result = moveCondition.moveOrNot();
        winOrLoseLog.add(result);
        setDistance(result);
    }

    private void setDistance(boolean result) {
        if (result)
            this.distance += 1;
    }

    public int getDistance() {
        return distance;
    }

    public static Car createCar(String name, List<Boolean> distance) {
        Car car = new Car();
        car.name = name;
        car.winOrLoseLog = distance;
        return car;
    }


    public Car() {
    }
}
