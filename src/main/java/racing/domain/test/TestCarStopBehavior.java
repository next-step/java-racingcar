package racing.domain.test;

import racing.domain.car.CarMoveBehavior;

public class TestCarStopBehavior implements CarMoveBehavior {
    private final static boolean STOP = false;

    @Override
    public boolean action(){
        return STOP;
    }
}
