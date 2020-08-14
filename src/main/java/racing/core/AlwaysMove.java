package racing.core;

public class AlwaysMove implements Move {

    @Override
    public boolean canMove() {
        return true;
    }
}
