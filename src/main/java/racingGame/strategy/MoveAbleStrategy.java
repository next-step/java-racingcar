package racingGame.strategy;

public class MoveAbleStrategy implements MoveStrategy{

    private static final int MOVE_ABLE_COUNT = 4;

    @Override
    public boolean moveable(int value) {
        if(value >= MOVE_ABLE_COUNT){
            return true;
        }
        return false;
    }
}
