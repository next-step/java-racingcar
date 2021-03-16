package racing.factories;

import racing.models.Racing;
import racing.simulators.RacingSimulator;

public class RacingSimulatorFactory {
    public static RacingSimulator createFrom(String[] carNames, int attemptsCount) {
        final Racing racing = RacingFactory.createFrom(carNames);
        return new RacingSimulator(racing, attemptsCount);
    }
}
