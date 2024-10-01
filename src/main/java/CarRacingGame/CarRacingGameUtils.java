package CarRacingGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static CarRacingGame.PrintView.printCars;

public class CarRacingGameUtils {
    private Map<String, String> cars;

    public Map<String, String> initialCarSettings(Integer numberOfCars) {
        cars = new HashMap<>();
        for (int i = 1; i <= numberOfCars; i++) {
            cars.put("car" + i, "-");
        }
        return cars;
    }

    public void printMovingCars(int numberOfAttempts) {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            PrintView.printCars(cars);
            moveCars();
            System.out.println();
        }
    }
    public void moveCars() {
        cars.forEach((carNumber, currentPosition) -> {
            String newPosition = makeDistanceOfCars(currentPosition);
            cars.put(carNumber, newPosition);
        });
    }
    public String makeDistanceOfCars(String currentPosition) {
        Random random = new Random();
        int randomValue = random.nextInt(10);
        if (randomValue >= 4) {
            currentPosition += "-";
        }
        return currentPosition;
    }
}
