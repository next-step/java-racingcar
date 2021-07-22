package racingcar.param;

public class RacingCarInitParam {
    private final String[] names;
    private final int totalRound;

    private RacingCarInitParam(int totalRound, String... names) {
        this.totalRound = totalRound;
        this.names = names;
    }

    public static RacingCarInitParam of(int totalRound, String... names) {
        return new RacingCarInitParam(totalRound, names);
    }

    public int getTotalRound() {
        return totalRound;
    }

    public String[] getNames() {
        return names;
    }
}
