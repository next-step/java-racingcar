package step3;

public class LapsManager {
    private final int END_LAP = 0;
    Count totalLaps;

    public LapsManager(Count totalLaps) {
        this.totalLaps = totalLaps;
    }

    public boolean isLastLap() {
        return totalLaps.getCount() == END_LAP;
    }

    public void finishLap() {
        this.totalLaps.minusCount();
    }

}
