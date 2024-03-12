package race;

import java.util.List;

public class RacingGame {

    public void start(Cars cars, int numberOfCars, int numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            List<String> firstMileages = cars.goForward(numberOfCars);
            for (int j = 0; j < numberOfCars; j++) {
                System.out.println(firstMileages.get(j));
            }
            System.out.println("\n");
        }
    }
}
