package domain;

import java.util.Random;

public class RandomCarDisplacement implements CarDisplacement{
    private final int successCount;
    private final int totalCount;
    Random random;

    private RandomCarDisplacement(int successCount, int totalCount) {
        this.random = new Random();
        this.successCount = successCount;
        this.totalCount = totalCount;
    }

    public static RandomCarDisplacement create(int successCount, int totalCount) {
        return new RandomCarDisplacement(successCount, totalCount);
    }

    @Override
    public int displacement() {
        if (random.nextInt(totalCount) >= successCount) {
            return Position.MOVE.getPosition();
        }
        return Position.STOP.getPosition();
    }
}
