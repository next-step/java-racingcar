package car_racing;

public class TestMoveStrategy implements MoveStrategy {
    @Override
    public boolean decideToMove() {
        System.out.println("TestMoveStrategy triggered");
        return true;
    }
}
