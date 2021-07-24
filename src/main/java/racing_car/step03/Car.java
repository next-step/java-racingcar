package racing_car.step03;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int drivingDistance;

    public void setDrivingDistance() {
        drivingDistance++;
    }

    public int getDrivingDistance(){
        return drivingDistance;
    }

    public static List<Car> buildCarObject(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
