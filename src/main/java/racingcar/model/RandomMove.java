package racingcar.model;

public class RandomMove implements Motor {

    private static final int MOVE_LIMIT_SPEED = 4;
    private static final int RANDOM_NUMBER = 10;
    private static final java.util.Random random = new java.util.Random();

    @Override
    public void run(Car car) {
        if (possibleMoveSpeedByRandomSpeed()) {
            car.move();
        }
    }

    public boolean possibleMoveSpeed(int speed) {
        return speed >= MOVE_LIMIT_SPEED;
    }

    public boolean possibleMoveSpeedByRandomSpeed() {
        return possibleMoveSpeed(getRandomSpeed());
    }

    public int getRandomSpeed() {
        return random.nextInt(RANDOM_NUMBER);
    }

}
