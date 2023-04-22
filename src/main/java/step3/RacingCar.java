package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    public static final int RANDOM_LIMIT = 10;
    public static final int LIMIT = 4;

    public void oneRace(List<Car> cars) {
        for (Car car : cars) {
            boolean isGo = isValueMoreThan(randomValue());
            goOrStop(isGo, car);
        }
    }

    public void goOrStop(boolean isGo, Car car) {
        if(isGo){
            car.addGoCount();
        }
    }

    public boolean isValueMoreThan(int value) {
        return value >= LIMIT;
    }

    private int randomValue() {
        Random random = new Random();
        int value = random.nextInt(RANDOM_LIMIT);
        return value;
    }

}
