package racing.domain.strategies;

public class CarMoveStrategyImpl implements CarMoveStrategy {

    private static final int MINIMUM_VALUE = 4;

    private final CustomRandom random;

    public CarMoveStrategyImpl(CustomRandom random) {
        this.random = random;
    }

    /**
     * 전진하는 조건 만족 여부 확인
     *
     * @return 전진 가능 여부
     */
    @Override
    public boolean isMovable() {
        int randomRange = random.getRandomRange(10);
        return randomRange >= MINIMUM_VALUE;
    }
}
