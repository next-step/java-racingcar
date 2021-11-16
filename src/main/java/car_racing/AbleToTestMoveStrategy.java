package car_racing;

public class AbleToTestMoveStrategy implements MoveStrategy {
    @Override
    public boolean decideToMove() {
        System.out.println("Test MoveStrategy triggered - car can move");
        return true;
    }
}
