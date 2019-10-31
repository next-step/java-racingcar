package project.game.controller;

import project.game.StringUtils;
import project.game.domain.Car;
import project.game.domain.GameType;
import project.game.domain.MoveRule;
import project.game.view.View;

import java.util.*;

import static project.game.TextConstant.*;

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

    private void initializeCars(GameType gameType) {
        List<String> carNames = getCarNames();
        MoveRule moveRule = gameType.getMoveRule();

        for (String each : carNames) {
            mCars.add(new Car(each, moveRule));
        }
    }

    private List<String> getCarNames() {
        String rawCarNamesText = readInput(CAR_NAME_INPUT_FORM_TEXT);
        return StringUtils.splitStringToList(rawCarNamesText.replace(" ", ""), COMMA_DELIMITER);
    }

    private void startRacing() {
        int roundCount = getRoundCount();

        if (roundCount == INVALID_ROUND_COUNT) {
            mView.drawText(INPUT_FORMAT_ERROR);
            return;
        }

        for (int i = 0; i < roundCount; i++) {
            moveCars();
            showCurrentCarPositions();
        }

        showWinners();
    }

    private void moveCars() {
        for (Car car : mCars) {
            car.moveIfPossible();
        }
    }

    private int getRoundCount() {
        String rawRoundCount = readInput(ROUND_COUNT_INPUT_FORM_TEXT);
        try {
            return Integer.valueOf(rawRoundCount);
        } catch (NumberFormatException numberFormatException) {
            return INVALID_ROUND_COUNT;
        }
    }

    private void endRacing() {
        mCars.clear();
    }

    private String readInput(String question) {
        mView.drawText(question);
        return mView.readInput();
    }

    private void showWinners() {
        String winnersText = String.format(RACING_GAME_WINNERS, String.join(COMMA_DELIMITER, findWinnerNames()));
        mView.drawText(winnersText);
    }

    private void showCurrentCarPositions() {
        mView.drawNewLine();

        for (Car each : mCars) {
            mView.drawText(each.getCurrentPositionText());
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
}
