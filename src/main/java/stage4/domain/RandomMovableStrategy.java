package stage4.domain;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy{
    private final static int STANDARD = 10;

    @Override
    public int getForwardPosition() {
        return new Random().nextInt(STANDARD);
    }
}
