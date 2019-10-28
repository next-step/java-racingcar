package project.game;

import java.util.ArrayList;
import java.util.List;

public class RacingGame implements RacingGameController {

    private GameType mGameType;
    private RacingGameView mRacingGameView;
    private List<Car> mCars;

    public RacingGame(RacingGameView racingGameView) {
        this.mRacingGameView = racingGameView;
        this.mCars = new ArrayList<>();

        mRacingGameView.setController(this);
    }

    @Override
    public void startGame(int carCount, int roundCount) {
        initializeCars(mGameType, carCount);
        startRacing(roundCount);
        endRacing();
    }

    public void start(GameType gameType) {
        mGameType = gameType;
        mRacingGameView.onStartGame();
    }

    private void endRacing() {
        mRacingGameView.onEndGame();
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

    private Car createCar(GameType gameType) {
        return new Car(gameType.getMoveRule());
    }


}
