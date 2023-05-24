package step3;

public class MovableMoveStrategy implements MoveStrategy {
    private static int THRESHOLD = 4;
    public boolean canMove() {
        int randomNumber = 4;
        return randomNumber >= THRESHOLD;
    }
}
