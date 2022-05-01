package racing;

public class AlwaysStopStrategy implements MovableStrategy{

    @Override
    public boolean canMove() {
        return false;
    }
}
