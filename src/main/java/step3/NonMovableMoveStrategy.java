package step3;

public class NonMovableMoveStrategy implements MoveStrategy {
    private static int THRESHOLD = 4;
    public boolean canMove() {
        int randomNumber = 3;
        return randomNumber >= THRESHOLD;
    }
}
