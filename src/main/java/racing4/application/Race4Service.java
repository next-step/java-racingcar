package racing4.application;

import racing4.domain.Race4Car;

import java.util.List;
import java.util.Random;

public class Race4Service {

    public static void playGame(List<Race4Car> race4Cars) {
        int randomNumber = new Random().nextInt(10);
        race4Cars.forEach(car -> car.moveForwardByCondition(randomNumber));
    }
}
