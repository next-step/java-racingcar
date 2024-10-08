package race.model;

public class RaceCount {
    private int raceCount;

    public RaceCount(int value) {
        this.raceCount = value;
    }

    public boolean hasMoreRaces() {
        return this.raceCount > 0;
    }

    public void decrease() {
        this.raceCount--;
    }
}
