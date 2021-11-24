package car_racing;

public class NotAbleToMoveStrategy implements MoveStrategy {

    @Override
    public boolean decideToMove() {
        System.out.println("Test MoveStrategy triggered - car can not move");
        return false;
    }
}
