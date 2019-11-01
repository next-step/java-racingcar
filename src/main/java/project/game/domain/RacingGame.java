package project.game.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RacingGame {

    private final List<Car> mCars;

    public RacingGame() {
        this.mCars = new ArrayList<>();
    }

    public void setNewGame(GameType gameType, List<String> carNames) {
        clear();

        MoveRule moveRule = gameType.getMoveRule();

        for (String each : carNames) {
            mCars.add(new Car(each, moveRule));
        }
    }

    private void clear() {
        mCars.clear();
    }

    public List<String> moveCars() {
        List<String> currentPositionTexts = new ArrayList<>();

        for (Car car : mCars) {
            car.moveIfPossible();
            currentPositionTexts.add(car.getCurrentPositionText());
        }

        return currentPositionTexts;
    }

    public List<String> getWinners() {
        return findWinnerNames();
    }

    private List<String> findWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = Collections.max(mCars, Comparator.comparingInt(Car::getMovePosition)).getMovePosition();

        for (Car each : mCars) {
            addWinnerNameIfPossible(winnerNames, each, maxPosition);
        }

        return winnerNames;
    }

    private void addWinnerNameIfPossible(List<String> winnerNames, Car car, int maxPosition) {
        if (car.hasEqualPositionTo(maxPosition)) {
            winnerNames.add(car.getName());
        }
    }
}
