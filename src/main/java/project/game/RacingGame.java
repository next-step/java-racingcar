package project.game;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static final char CAR_POSITION_TEXT = '-';
    private static final int NOT_SET_POSITION = Integer.MIN_VALUE;

    private RacingGameNotifier mRacingGameNotifier;
    private List<Car> mCars;
    private int mMaxPosition;

    public RacingGame(RacingGameNotifier racingGameNotifier) {
        this.mRacingGameNotifier = racingGameNotifier;
        this.mCars = new ArrayList<>();
        this.mMaxPosition = NOT_SET_POSITION;
    }

    public void start(GameType gameType, List<String> carNames, int roundCount) {
        initializeCars(gameType, carNames);
        startRacing(roundCount);
        endRacing();
    }

    private void endRacing() {
        mCars.clear();
        mMaxPosition = NOT_SET_POSITION;
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

        mRacingGameNotifier.onResultRacingWinnerNames(findWinnerNames());
    }

    private void notifyCarPositionsChange(List<Integer> currentCarPositions) {
        mRacingGameNotifier.onResultRacingRound(currentCarPositions);
    }

    private List<String> findWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (Car each : mCars) {
            addWinnerNameIfPossible(winnerNames, each);
        }

        return winnerNames;
    }

    private void addWinnerNameIfPossible(List<String> winnerNames, Car car) {
        if (car.canBeWinner(mMaxPosition)) {
            winnerNames.add(car.getName());
        }
    }

    private List<Integer> moveCars() {
        List<Integer> currentCarPositions = new ArrayList<>();

        for (int i = 0; i < mCars.size(); i++) {
            int currentPosition = mCars.get(i).moveIfPossible();
            currentCarPositions.add(i, currentPosition);
            updateMaxPositionIfPossible(currentPosition);
        }

        return currentCarPositions;
    }

    private void updateMaxPositionIfPossible(int position) {
        if (mMaxPosition < position) {
            mMaxPosition = position;
        }
    }

    private Car createCar(String name, GameType gameType) {
        return new Car(name, gameType.getMoveRule());
    }
}
