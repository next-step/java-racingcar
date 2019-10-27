package game;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> mCars;

    public RacingGame() {
        mCars = new ArrayList<>();
    }

    public void start(GameType gameType, int carCount, int round) {
        initializeCars(gameType, carCount);
    }

    private void initializeCars(GameType gameType, int carCount) {
        for (int i = 0; i < carCount; i++) {
            mCars.add(createCar(gameType));
        }
    }

    public void end() {
        mCars.clear();
    }

    private static Car createCar(GameType gameType) {
        return new Car(gameType.getMoveRule());
    }
}
