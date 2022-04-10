package racing.model;

public class CarMoveStrategyImpl implements CarMoveStrategy {

    private static final int MINIMUM_VALUE = 4;

    private final CustomRandom random;

    public CarMoveStrategyImpl(CustomRandom random) {
        this.random = random;
    }

    /**
     * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다
     *
     * @return 전진 가능 여부
     */
    @Override
    public boolean isMovable() {
        int randomRange = random.getRandomRange(10);
        return randomRange >= MINIMUM_VALUE;
    }
}
