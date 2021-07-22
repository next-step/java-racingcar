package racing_car.step03;

import java.util.Arrays;
import java.util.Random;

public class Race {

    private Random r = new Random();

    public String[] car(int count, String []cars) {
        for (int j = 0; j < count; j++) {
            int random = r.nextInt(10);
            if (random >= 4) {
                cars[j] += "-";
            }
        }
        return cars;
    }
}
