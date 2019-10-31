package project.game.controller;

import project.game.StringUtils;
import project.game.domain.Car;
import project.game.domain.GameType;
import project.game.view.View;

import java.util.ArrayList;
import java.util.List;

import static project.game.StringConstant.*;
import static project.game.StringConstant.ROUND_COUNT_INPUT_FORM_TEXT;

public class RacingGameController {

    public static final char CAR_POSITION_TEXT = '-';
    private static final int NOT_SET_POSITION = Integer.MIN_VALUE;

    private View mView;
    private List<Car> mCars;
    private int mMaxPosition;

    public RacingGameController(View view) {
        this.mView = view;
        this.mCars = new ArrayList<>();
        this.mMaxPosition = NOT_SET_POSITION;
    }

    public void start(GameType gameType) {
        mView.drawText(RACING_GAME_START_TEXT);

        mView.drawText(CAR_NAME_INPUT_FORM_TEXT);
        List<String> carNames = StringUtils.splitStringToList(mView.readInput(), COMMA_DELIMITER);
        mView.drawText(ROUND_COUNT_INPUT_FORM_TEXT);
        int roundCount = mView.readInputToInt();

        initializeCars(gameType, carNames);
        startRacing(roundCount);
        endRacing();
    }

    private void endRacing() {
        mView.drawText(RACING_GAME_END_TEXT);

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


        mView.drawText(RACING_GAME_END_TEXT);

        String winnerText = String.format(RACING_GAME_WINNERS, String.join(COMMA_DELIMITER, findWinnerNames()));
        mView.drawText(winnerText);
    }

    private void notifyCarPositionsChange(List<Integer> currentCarPositions) {
        mView.drawNewLine();

        for (Integer carPosition : currentCarPositions) {
            mView.drawCharSequence(carPosition, RacingGameController.CAR_POSITION_TEXT);
        }
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
