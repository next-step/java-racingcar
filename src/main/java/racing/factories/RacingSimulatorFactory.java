package racing.factories;

import racing.models.Racing;
import racing.simulator.RacingSimulator;

public class RacingSimulatorFactory {
    public static RacingSimulator createFrom(int carsCount, int attemptsCount) {
        final Racing racing = RacingFactory.createFrom(carsCount);
        return new RacingSimulator(racing, attemptsCount);
    }

    public static RacingSimulator createFrom(String[] carNames, int attemptsCount) {
        final Racing racing = RacingFactory.createFrom(carNames);
        return new RacingSimulator(racing, attemptsCount);
    }
}
