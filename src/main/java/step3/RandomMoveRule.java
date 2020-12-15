package step3;

public class RandomMoveRule implements MoveRule {

    private RandomMoveRule() {
    }

    @Override
    public boolean canMove() {
        return canMoveWithNumber(RandomNumberGenerator.generate());
    }

    public static boolean canMoveWithNumber(int number) {
        return number >= 4;
    }
}
