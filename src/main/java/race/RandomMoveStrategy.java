package race;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public int getNumber() {
        return new Random().nextInt(10);
    }
}
