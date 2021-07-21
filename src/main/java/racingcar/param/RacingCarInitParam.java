package racingcar.param;

import java.util.stream.IntStream;

public class RacingCarInitParam {
    private final String[] names;
    private final int numberOfCars;
    private final int totalRound;

    private RacingCarInitParam(int numberOfCars, int totalRound) {
        this.names = IntStream.range(0, numberOfCars)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        this.numberOfCars = numberOfCars;
        this.totalRound = totalRound;
    }

    private RacingCarInitParam(int totalRound, String... names) {
        this.numberOfCars = names.length;
        this.totalRound = totalRound;
        this.names = names;
    }

    public static RacingCarInitParam of(int numberOfCars, int totalRound) {
        return new RacingCarInitParam(numberOfCars, totalRound);
    }

    public static RacingCarInitParam of(int totalRound, String... names) {
        return new RacingCarInitParam(totalRound, names);
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTotalRound() {
        return totalRound;
    }

    public String[] getNames() {
        return names;
    }
}
