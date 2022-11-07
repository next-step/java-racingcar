package carracing.domain;

import java.util.Random;

public class MovableNumberGenerator implements NumberGenerator{
    @Override
    public int generate() {
        return 5;
    }
}
