package study03;

public class RacingCar {

    private Engine engine = new Engine();
    private int moveCount = 1;

    public void move() {
        if (engine.isRun()) {
            moveCount++;
        }
    }

    public String tracking(Track track) {
        return track.getTotalTrack().substring(0, moveCount);
    }

    @Override
    public String toString() {
        return "자동차";
    }

    //Test Code Only
    public void fixedMove(int fixedValue) {
        if (engine.isFixedRun(fixedValue)) {
            moveCount++;
        }
    }

}
