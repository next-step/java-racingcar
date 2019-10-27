package game;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> mCars;

    public RacingGame() {
        mCars = new ArrayList<>();
    }

    public void start(int carCount, int round) {
        initializeCars(carCount);
    }

    private void initializeCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            mCars.add(new RandomlyMoveCar());
        }
    }

    public void end() {
        mCars.clear();
    }
}
