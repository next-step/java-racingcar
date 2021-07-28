package step5.domain.strategy;

public class CarMoveStrategy implements CarStrategy {
    private final int MOVE_BOUNDARY = 4;

    @Override
    public boolean isMove(int randomNumber) {
        if(randomNumber >= MOVE_BOUNDARY){
            return true;
        }
        return false;
    }
}
