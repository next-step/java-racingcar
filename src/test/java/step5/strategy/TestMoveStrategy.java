package step5.strategy;

public class TestMoveStrategy implements MoveStrategy{
    @Override
    public boolean strategy() {
        return false;
    }
    public static MoveStrategy unconditionalForwardStrategy(){
        return ()->true;
    }
    public static MoveStrategy unconditionalStopStrategt(){
        return ()->false;
    }
}
