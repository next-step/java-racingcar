package carracing;

public class RandomMovingStrategy implements MovingStrategy {
    @Override
    public boolean canMove(int randomNumber) {
        return randomNumber >= 4;
    }
}