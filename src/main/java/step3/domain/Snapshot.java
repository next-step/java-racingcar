package step3.domain;

public class Snapshot {
    private final int number;
    private final RacingMap racingMap;

    public Snapshot(final int number, final RacingMap racingMap) {
        this.number = number;
        this.racingMap = racingMap.clone();
    }

    public int getNumber() {
        return number;
    }

    public RacingMap getRacingMap() {
        return racingMap;
    }
}
