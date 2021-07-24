package racing_car.step03;

import java.util.Random;

public class Race {
    private Random random = new Random();
    private static final int MIN_NUMBER = 4;
    private static final int BORDER = 10;
    private static final String DISTANCE_SYMBOL = "-";

    public void execute(String[] cars) {
        for (int i = 0; i < cars.length; i++) {
            if (move(getRandomNumber())) {
                cars[i] += DISTANCE_SYMBOL;
            }
        }
    }

    public boolean move(int number) {
        return number >= MIN_NUMBER;
    }

    public int getRandomNumber() {
        return random.nextInt(BORDER);
    }
}
