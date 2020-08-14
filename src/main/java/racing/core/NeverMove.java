package racing.core;

public class NeverMove implements Move {

    @Override
    public boolean canMove() {
        return false;
    }
}
