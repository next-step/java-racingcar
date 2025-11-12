package racingGame;

public class TestPositions {

    public static class AlwaysMove extends Position {
        @Override
        public boolean canMove() { return true; }
    }

    public static class NeverMove extends Position {
        @Override
        public boolean canMove() { return false; }
    }
}
