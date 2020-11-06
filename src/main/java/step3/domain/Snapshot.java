package step3.domain;

public class Snapshot {
    private final RacingMap racingMap;

    private Snapshot(final RacingMap racingMap) {
        this.racingMap = racingMap;
    }
    
    public static Snapshot of(final RacingMap racingMap) {
        return new Snapshot(racingMap);
    }

    public RacingMap getRacingMap() {
        return racingMap;
    }
}
