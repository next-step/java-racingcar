package race;

import java.util.List;
import java.util.Random;

public class RacingGame {

    private final int randomNumber = new Random().nextInt(10);

    public void start(Cars cars, int numberOfCars, int numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            List<String> firstMileages = cars.goForward(numberOfCars, i, randomNumber);
            for (int j = 0; j < numberOfCars; j++) {
                System.out.println(firstMileages.get(j));
            }
            System.out.println("\n");
        }
    }
}
