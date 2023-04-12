package domain;

public class RaceNumber {
    private final int raceNumber;
    public RaceNumber(int raceNumber) {
        if (raceNumber < 0)
            throw new RuntimeException("CarNumber can not be negative");
        this.raceNumber = raceNumber;
    }

    public int getRaceNumber() {
        return raceNumber;
    }
}
