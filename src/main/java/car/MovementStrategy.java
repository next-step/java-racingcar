package car;

import java.util.Random;

public class MovementStrategy {

    Random random = new Random();
    public int randomMoveStrategy(){
        return random.nextInt(10);
    }

    public int stopMoveStrategy(){
        return random.nextInt(4);
    }

    public int goMoveStrategy(){
        return random.nextInt(6)+4;
    }
}
