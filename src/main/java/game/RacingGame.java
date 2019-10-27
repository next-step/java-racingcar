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

    public void end() {
        mCars.clear();
    }

    private void initializeCars(GameType gameType, int carCount) {
        for (int i = 0; i < carCount; i++) {
            mCars.add(createCar(gameType));
        }
    }

    private void startRacingRound(int totalRound) {
        for (int i = 0; i < totalRound; i++) {
            moveCars();
        }
    }

    private List<Integer> moveCars() {
        List<Integer> currentMovePosition = new ArrayList<>();

        for (int i = 0; i < mCars.size(); i++) {
            currentMovePosition.add(i, mCars.get(i).moveIfPossible());
        }

        return currentMovePosition;
    }

    private static Car createCar(GameType gameType) {
        return new Car(gameType.getMoveRule());
    }
}
