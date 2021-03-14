package step3;

public class RandomMoveStrategy implements MoveStrategy {

    private final int bound;
    private final int limit;

    public RandomMoveStrategy(int bound, int limit) {
        this.bound = bound;
        this.limit = limit;
    }

    @Override
    public boolean isMove() {
        return RandomUtil.nextInt(bound) >= limit;
    }
}
