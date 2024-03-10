package racinggame.view;

public class RaceCount {

    private int raceCount;

    public RaceCount(int raceCount) {
        validationRaceCount(raceCount);
        this.raceCount = raceCount;
    }

    private void validationRaceCount(int carsCount) {
        if (isNegativeValue(carsCount)) {
            throw new IllegalStateException("시도할 회수가 음수 입력입니다.");
        }
    }

    private boolean isNegativeValue(int carsCount) {
        return carsCount < 0;
    }

    public int value() {
        return raceCount;
    }
}
