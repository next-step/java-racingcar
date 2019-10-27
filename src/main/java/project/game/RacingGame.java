package project.game;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private RacingGameView mRacingGameView;
    private List<Car> mCars;

    public RacingGame(RacingGameView racingGameView) {
        this.mRacingGameView = racingGameView;
        this.mCars = new ArrayList<>();
    }

    public void start(GameType gameType, int carCount, int round) {
        initializeCars(gameType, carCount);
        startRacing(round);
    }

    public void end() {
        mCars.clear();
    }

    private void initializeCars(GameType gameType, int carCount) {
        for (int i = 0; i < carCount; i++) {
            mCars.add(createCar(gameType));
        }
    }

    private void startRacing(int totalRound) {
        for (int i = 0; i < totalRound; i++) {
            List<Integer> currentCarPositions = moveCars();
            notifyCarPositionsChange(currentCarPositions);
        }
    }

    private void notifyCarPositionsChange(List<Integer> currentCarPositions) {
        mRacingGameView.onCarPositionsChange(currentCarPositions);
    }

    private List<Integer> moveCars() {
        List<Integer> currentCarPositions = new ArrayList<>();

        for (int i = 0; i < mCars.size(); i++) {
            int currentPosition = mCars.get(i).moveIfPossible();
            currentCarPositions.add(i, currentPosition);
        }

        return currentCarPositions;
    }

    private static Car createCar(GameType gameType) {
        return new Car(gameType.getMoveRule());
    }
}
