package carRacing.util;

public class GreaterThenThreeMoveStrategy implements MoveStrategy {
    @Override
    public boolean isRide(int number) {
        return number > 3;
    }
}
