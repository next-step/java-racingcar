package racingcar.domain;

public class Race {
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

    public String getWinnersName() {
        if (winners == null) {
            findWinners();
        }

        return winners.getName();
    }

    public String getCurrentRoundString() {
        return currentRound.toString();
    }

    public String getCarsStateInString() {
        return cars.getCarsStateInString();
    }
}