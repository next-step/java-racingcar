package racing.domain;


import java.util.Random;

public class CarMovable implements Movable{

    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM = 10;


    @Override
    public int move() {
        return RANDOM.nextInt(MAX_RANDOM);
    }
}
