package step3_racing_car;

import java.util.Random;

public class ForwardStrategy implements MovingStrategy {
    @Override
    public int getMovingDistance() {
        return 1;
    }
}
