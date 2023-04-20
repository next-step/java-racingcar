package step3;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static step3.output.ResultView.printRace;

public class RacingCar {

    public static final int RANDOM_LIMIT = 10;
    public static final int LIMIT = 4;

    public void oneRace(List<Car> cars) {
        for (Car car : cars) {
            boolean goStop = isValueMoreThan(randomValue());
            car.goOrStop(goStop);
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

    protected static List<Car> initCars(int car){
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<car; i++){
            cars.add(new Car());
        }
        return cars;
    }

}
