package racing_car.step03;

import java.util.List;
import java.util.Random;

public class Race {
    private Random random = new Random();
    private static final int MIN_NUMBER = 4;
    private static final int BORDER = 10;

    public void startRacingGame(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            if (generateRandomNumber() >= MIN_NUMBER) {
                cars.get(i).setDrivingDistance();
            }
        }
    }

    public int generateRandomNumber() {
        return random.nextInt(BORDER);
    }
}
