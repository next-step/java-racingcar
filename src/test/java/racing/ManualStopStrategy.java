package racing;

public class ManualStopStrategy implements MovingStrategy {
    @Override
    public boolean isMove(int randomValue) {
        return false;
    }
}
