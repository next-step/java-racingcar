package racing.domain;

import java.util.List;

public class RacingSimulator {
    private final Racing racing;
    private final int attemptsCount;

    public RacingSimulator(String[] carNames, int attemptsCount) {
        this(new Racing(carNames), attemptsCount);
    }

    public RacingSimulator(Racing racing, int attemptsCount) {
        this.racing = racing;
        this.attemptsCount = attemptsCount;
    }

    public void start() {
        while (racing.hasRun(attemptsCount)) {
            racing.runRace();
        }
    }

    public Rounds getRounds() {
        return racing.getRounds();
    }

    public List<Car> getWinnerList() {
        return racing.getWinnerList();
    }
}
