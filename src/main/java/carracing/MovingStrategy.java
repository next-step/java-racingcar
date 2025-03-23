package carracing;

@FunctionalInterface
public interface MovingStrategy {
    boolean canMove(int randomNumber);
}
