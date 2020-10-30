package study;

import java.util.Random;

public class RealCar implements Car {
    private boolean moved;
    private final Random random;
    private final Long id;

    public RealCar() {
        this.random = new Random();
        this.id = random.nextLong();
    }

    @Override
    public boolean isMoved() {
        return moved;
    }

    @Override
    public void move() {
        moved = guessMove();
    }

    private boolean guessMove() {
        return random.nextInt(10) >= 4;
    }

    @Override
    public Long getId() {
        return id;
    }
}
