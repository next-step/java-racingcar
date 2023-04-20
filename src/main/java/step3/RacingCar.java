package step3;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    public static final int RANDOM_LIMIT = 10;
    private int randomValue() {
        Random random = new Random();
        int value = random.nextInt(RANDOM_LIMIT);
        return value;
    }

    List<Car> initCars(int car){
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<car; i++){
            cars.add(new Car());
        }
        return cars;
    }
}
