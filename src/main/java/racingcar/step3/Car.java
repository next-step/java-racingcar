package racingcar.step3;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int drivingDistance;
    private final int MIN_NUMBER = 4;

    public void setDrivingDistance(int number) {
        if (number>=MIN_NUMBER){
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
    public void move(){
        setDrivingDistance(RandomUtil.generateRandomNumber());
    }
}
