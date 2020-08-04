package step3;

import step3.domain.Car;

import java.util.Random;

public class RacingCar {

    public static int getAccelateNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static String racing(Car car, int racingCondition) {
        if (racingCondition > 3) {
            return car.accelerate();
        }
        return car.brake();
    }



}
