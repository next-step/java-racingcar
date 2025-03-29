package racingcar.domain;

public class NumberOverFourMovement implements Movement {

    public static final int MOVE_BOUNDARY_INCLUSIVE = 4;

    private final NumberGenerator numberGenerator;

    public NumberOverFourMovement(NumberGenerator numberStrategy) {
        this.numberGenerator = numberStrategy;
    }

    @Override
    public boolean canMove() {
        return numberGenerator.generate() >= MOVE_BOUNDARY_INCLUSIVE;
    }
}
