package racinggame;

import java.util.HashMap;
import java.util.Map;

public class Car {
    public static final int MOVE_DISTANCE_PER_ONCE = 1;
    public static final int INITIAL_CAR_POSITION = 1;

    private int position;
    private String carName;

    private Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public Car(String carName) {
        this(carName, INITIAL_CAR_POSITION);
    }

    public Car move() {
        return new Car(this.carName, this.position + MOVE_DISTANCE_PER_ONCE);
    }

    public Map<String, Integer> getCarMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put(getCarName(), getPosition());
        return map;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
