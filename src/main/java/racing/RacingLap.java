package racing;

public class RacingLap {

    private final int lap;

    private RacingLap(int lap) {
        this.lap = lap;
    }

    public static RacingLap init(int lap) {
        return new RacingLap(lap);
    }

    public int getLap() {
        return lap;
    }
}
