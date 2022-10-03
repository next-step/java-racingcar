package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarFactory {
    private final int numOfCars;
    private final int tryingCount;
    private final Random random = new Random();

    private static RacingCarFactory factory; // singleton

    private RacingCarFactory(int numOfCars, int tryingCount) {
        this.numOfCars = numOfCars;
        this.tryingCount = tryingCount;
    }

    public static RacingCarFactory getFactory(int numOfCars, int tryingCount) {
        if(factory == null) {
            factory = new RacingCarFactory(numOfCars, tryingCount);
            return factory;
        }
        return factory;
    }

    public List<RacingCar> manufactoringCars() {
        List<RacingCar> cars = new ArrayList<>(numOfCars);
        for(int i=0 ; i<numOfCars ; i++) {
            cars.add(new RacingCar(random, tryingCount));
        }
        return cars;
    }
}
