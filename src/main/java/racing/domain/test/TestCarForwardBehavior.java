package racing.domain.test;

import racing.domain.car.CarMoveBehavior;

public class TestCarForwardBehavior implements CarMoveBehavior {
    private final boolean GO = true;

    @Override
    public boolean action(){
        return true;
    }
}
