package racing.domain.car;

import racing.utils.RandomNumber;

public class CarForwardBehavior implements CarMoveBehavior {
    private final static int BOUND_NUMBER = 10;
    private final static int LIMIT_NUMBER = 4;

    @Override
    public boolean action() {
        return RandomNumber.getRandomNumber(BOUND_NUMBER) >= LIMIT_NUMBER;
    }
}
