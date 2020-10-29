package step3.domain;

import java.util.Random;

public class GameStrategy implements Strategy{
    private static final int BOUNDARY = 10;

    public GameStrategy() {}

    @Override
    public boolean isMoved() {
        return new Random().nextInt(BOUNDARY) > 4;
    }


}
