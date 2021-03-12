package racingcar.domain.racing;

public class RacingRound {
    private static final int START_VALUE = 0;

    private int now;
    private int finish;

    public static RacingRound from(int finish) {
        return new RacingRound(finish);
    }

    private RacingRound(int finish) {
        this.finish = finish;
        this.now = START_VALUE;
    }

    public boolean hasNext() {
        return now < finish;
    }

    public void nextRound() {
        now++;
    }

}
