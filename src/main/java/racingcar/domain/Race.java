package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Race {
    public static final int MIN_ROUND_NUM = 1;
    private static final String STR_RACE_NOT_OVER_YET = "아직 경기가 끝나지 않았습니다.";

    private Cars cars;
    private Winners winners;

    private int roundNum;
    private int currentRound;

    public Race(String[] carNames, int roundNum) {
        this.roundNum = roundNum;
        checkIfValidArgumentsForRace(roundNum);

        currentRound = 0;
        cars = new Cars(carNames);
    }

    Race() {
        this(new String[]{"Unknown"}, 1);
    }

    void checkIfValidArgumentsForRace(int roundNum) throws IllegalArgumentException {
        if (!isValidRoundNum(roundNum)) {
            throw new IllegalArgumentException("Invalid Arguments for Race");
        }
    }

    public boolean isValidRoundNum(int roundNum) {
        return roundNum >= MIN_ROUND_NUM;
    }

    public List<Car> getCars() {
        return cars.getCarsList();
    }

    public void runOneRound() {
        cars.runOneRound();

        currentRound++;
    }

    public boolean isRaceOver() {
        return roundNum == currentRound;
    }

    public void findWinners() {
        winners = cars.calculateWinners();
    }

    public String getWinnersInString() {
        try {
            return winners.toString();
        } catch (NullPointerException e) {
            if (isRaceOver() == false) {
                return STR_RACE_NOT_OVER_YET;
            }

            findWinners();
            return winners.toString();
        }
    }

    public String getCurrentStateInString() {
        return "< Round " + currentRound + " >\n" + cars.getCarsStateInString();
    }
}