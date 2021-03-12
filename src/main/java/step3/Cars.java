package step3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cars {
    private final int randomNumberRange = 10;
    private final Map<Integer, String> cars = new HashMap<>();

    public Cars(int participants) {
        for (int i = 0; i < participants; i++) {
            cars.put(i, "-");
        }
    }

    public Map<Integer, String> getCars() {
        return this.cars;
    }

    public void move() {
        for (int i = 0; i < this.cars.size(); i++) {
            int random = new Random().nextInt(randomNumberRange);
            this.cars.put(i, moveDecision(random, this.cars.get(i)));
        }
    }

    public String moveDecision(int random, String car) {
        if (random >= 4) {
            car += "-";
        }
        return car;
    }

}
