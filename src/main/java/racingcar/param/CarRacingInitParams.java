package racingcar.param;

public class CarRacingInitParams {
    private final String[] names;
    private final int totalRound;

    private CarRacingInitParams(int totalRound, String... names) {
        this.totalRound = totalRound;
        this.names = names;
    }

    public static CarRacingInitParams of(int totalRound, String... names) {
        return new CarRacingInitParams(totalRound, names);
    }

    public int getTotalRound() {
        return totalRound;
    }

    public String[] getNames() {
        return names;
    }
}
