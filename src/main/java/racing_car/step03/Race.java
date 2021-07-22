package racing_car.step03;

import java.util.Random;
public class Race {
    private Random r = new Random();
    private final int MIN_NUMBER =4;

    public String[] car(int count, String []cars) {
        for (int j = 0; j < count; j++) {
            int random = r.nextInt(10);
            if (random >= MIN_NUMBER) {
                cars[j] += "-";
            }
        }
        return cars;
    }
}
