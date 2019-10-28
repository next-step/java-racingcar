package project.game;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static final char CAR_POSITION_TEXT = '-';

    private GameType mGameType;
    private RacingGameNotifier mRacingGameNotifier;
    private List<Car> mCars;

    public RacingGame(RacingGameNotifier racingGameNotifier) {
        this.mRacingGameNotifier = racingGameNotifier;
        this.mCars = new ArrayList<>();
    }

    public void start(GameType gameType, List<String> carNames, int roundCount) {
        mGameType = gameType;
        initializeCars(mGameType, carNames);
        startRacing(roundCount);
        endRacing();
    }

    private void endRacing() {
        mCars.clear();
    }

    private void initializeCars(GameType gameType, List<String> carNames) {
        for (String each : carNames) {
            mCars.add(createCar(each, gameType));
        }
    }

    private void startRacing(int totalRound) {
        for (int i = 0; i < totalRound; i++) {
            List<Integer> currentCarPositions = moveCars();
            notifyCarPositionsChange(currentCarPositions);
        }
    }

    private void notifyCarPositionsChange(List<Integer> currentCarPositions) {
        mRacingGameNotifier.onResultRacingRound(currentCarPositions);
    }

    private List<Integer> moveCars() {
        List<Integer> currentCarPositions = new ArrayList<>();

        for (int i = 0; i < mCars.size(); i++) {
            int currentPosition = mCars.get(i).moveIfPossible();
            currentCarPositions.add(i, currentPosition);
        }

        return currentCarPositions;
    }

    private Car createCar(String name, GameType gameType) {
        return new Car(name, gameType.getMoveRule());
    }


}
