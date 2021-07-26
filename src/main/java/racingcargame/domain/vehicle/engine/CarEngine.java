package racingcargame.domain.vehicle.engine;

import java.util.Random;
import racingcargame.domain.common.Distance;

public class CarEngine implements Engine {

    private static final Random RANDOM = new Random();

    private static final int INPUT_MAX = 10;
    private static final int RUNNING_FLAG = 4;

    private static final Distance RUNNING = new Distance(1);
    private static final Distance STOP = new Distance(0);

    @Override
    public Distance running() {
        if (RANDOM.nextInt(INPUT_MAX) >= RUNNING_FLAG) {
            return RUNNING;
        }

        return STOP;
    }
}
