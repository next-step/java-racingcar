package racingcar.domain;

public class Race {
    static final String STR_RACE_NOT_OVER_YET = "아직 경기가 끝나지 않았습니다.";

    private Cars cars;
    private Winners winners;
    private RoundNum roundNum;
    private CurrentRound currentRound;

    public Race(String[] carNames, int round) {
        roundNum = new RoundNum(round);
        cars = new Cars(carNames);
        currentRound = new CurrentRound();
    }

    Race(int round) {
        this(new String[]{"Unknown"}, round);
    }

    public void runOneRound() {
        cars.runOneRound();
        roundNum = roundNum.runOneRound();
        currentRound = currentRound.runOneRound();
    }

    public boolean isRaceOver() {
        return roundNum.isRoundOver();
    }

    public void findWinners() {
        winners = cars.calculateWinners();
    }

    public String getWinnersInString() {
        if (winners == null) {
            findWinners();
        }

        if (isRaceOver() == false) {
            return STR_RACE_NOT_OVER_YET;
        }

        return winners.toString();
    }

    public String getCurrentStateInString() {
        return currentRound.toString() + "\n" + cars.getCarsStateInString();
    }
}