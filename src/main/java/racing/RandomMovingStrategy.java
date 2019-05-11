package racing;

public class RandomMovingStrategy implements MovingStrategy {
    @Override
    public boolean isMove(int randomValue) {
        return randomValue > Consts.MOVE_MIN_COUNT;
    }
}
