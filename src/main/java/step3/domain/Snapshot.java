package step3.domain;

public class Snapshot {
    private final RacingMap racingMap;

    public Snapshot(final RacingMap racingMap) {
        this.racingMap = racingMap.clone();
    }

    public RacingMap getRacingMap() {
        return racingMap;
    }
}
