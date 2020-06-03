package step5.strategy;

import java.util.Random;

public class ProdMove implements MoveStrategy {

    private Random random = new Random();

    @Override
    public boolean move() {
        return random.nextInt(10) >= 4;
    }
}
