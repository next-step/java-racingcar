package racing_car.step03;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int drivingDistance;
    private final int MIN_NUMBER = 4;

    public void setDrivingDistance() {
        if (RandomUtil.generateRandomNumber()>=MIN_NUMBER){
            drivingDistance++;
        }
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
