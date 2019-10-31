package project.game.controller;

import project.game.StringUtils;
import project.game.domain.Car;
import project.game.domain.GameType;
import project.game.domain.MoveRule;
import project.game.view.View;

import java.util.*;

import static project.game.TextConstant.*;
import static project.game.TextConstant.ROUND_COUNT_INPUT_FORM_TEXT;

public class RacingGameController {

    private static final int INVALID_ROUND_COUNT = -1;

    private View mView;
    private List<Car> mCars;

    public RacingGameController(View view) {
        this.mView = view;
        this.mCars = new ArrayList<>();
    }

    public void start(GameType gameType) {
        mView.drawText(RACING_GAME_START_TEXT);

        initializeCars(gameType);
        startRacing();
        endRacing();
    }

    private void endRacing() {
        mCars.clear();
    }

    private void initializeCars(GameType gameType) {
        List<String> carNames = getCarNames();
        MoveRule moveRule = gameType.getMoveRule();

        for (String each : carNames) {
            mCars.add(new Car(each, moveRule));
        }
    }

    private List<String> getCarNames() {
        String rawCarNamesText = readInput(CAR_NAME_INPUT_FORM_TEXT);
        return StringUtils.splitStringToList(rawCarNamesText, COMMA_DELIMITER);
    }

    private void startRacing() {
        int roundCount = getRoundCount();

        if (roundCount == INVALID_ROUND_COUNT) {
            mView.drawText(INPUT_FORMAT_ERROR);
            return;
        }

        for (int i = 0; i < roundCount; i++) {
            List<Integer> currentCarPositions = moveCars();
            showCarPositions(currentCarPositions);
        }

        showWinners();
    }

    private int getRoundCount() {
        String rawRoundCount = readInput(ROUND_COUNT_INPUT_FORM_TEXT);
        try {
            return Integer.valueOf(rawRoundCount);
        } catch (NumberFormatException numberFormatException) {
            return INVALID_ROUND_COUNT;
        }
    }

    private String readInput(String question) {
        mView.drawText(question);
        return mView.readInput();
    }

    private void showWinners() {
        String winnersText = String.format(RACING_GAME_WINNERS, String.join(COMMA_DELIMITER, findWinnerNames()));
        mView.drawText(winnersText);
    }

    private void showCarPositions(List<Integer> currentCarPositions) {
        mView.drawNewLine();

        for (Integer carPosition : currentCarPositions) {
            mView.drawCharSequence(carPosition, CAR_POSITION_TEXT);
        }
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

    private List<Integer> moveCars() {
        List<Integer> currentCarPositions = new ArrayList<>();

        for (int i = 0; i < mCars.size(); i++) {
            int currentPosition = mCars.get(i).moveIfPossible();
            currentCarPositions.add(i, currentPosition);
        }

        return currentCarPositions;
    }
}
