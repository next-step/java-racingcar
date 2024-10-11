package carracing.domain.carracing.dto;

import carracing.domain.carracing.Car;

import java.util.Random;

public class RandomNumberMoveStrategy implements MoveStrategy {
    private static final Random RANDOM = new Random();
    private static final int MOVE_REFERENCE_NUM = 4;
    private static final int LIMIT_RANDOM_NUM = 10;

    @Override
    public void move(Car car) {
        if (RANDOM.nextInt(LIMIT_RANDOM_NUM) >= MOVE_REFERENCE_NUM) {
            car.move();
        }
    }
}