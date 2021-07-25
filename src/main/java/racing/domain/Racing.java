package racing.domain;

public class Racing {

    private boolean[] racing;

    public Racing(boolean[] racing) {
        this.racing = racing;
    }
    public int getRacingLength() {
        return racing.length;
    }

    public boolean getRacingResult(int car) {
        return racing[car];
    }

}
