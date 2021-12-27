package racing.utils;

public class UnmovableValueMovingStrategy implements MovingStrategy {

    @Override
    public boolean isMovable() {
        return false;
    }

}
