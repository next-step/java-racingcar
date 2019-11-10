package step2.move;

public class RandomMove implements MoveStrategy {

    private static final int MINIMUM_RANDOM_VALUE = 4;

    @Override
    public boolean isPossibleToGo() {
        int random = (int) (Math.random() * 10);
        return random >= MINIMUM_RANDOM_VALUE;
    }
}
