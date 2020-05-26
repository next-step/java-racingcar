package step3;

import java.util.ArrayList;
import java.util.Random;

public class RacingGame {
    private ArrayList<Car> carPositions = new ArrayList<Car>();
    private Random random = new Random();

    public RacingGame(int carCnt) {
        for (int i = 0; i < carCnt; i++) {
            carPositions.add(new Car());
        }
    }

    public ArrayList<Car> play() {
        for (int i = 0; i < carPositions.size(); i++) {
            if (getDistance())
                carPositions.get(i).move();
        }
        return carPositions;
    }

    private boolean getDistance() {
        return random.nextInt(10) >= 4;
    }
}
