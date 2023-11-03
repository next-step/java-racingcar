package racing;

public class Car {
    private int THRESHOLD = 4;
    private Position position;

    public Car() {
        this.position = new Position(0);
    }

    public int position() {
        return this.position.position();
    }

    public void move(int input) {
        if (THRESHOLD <= input) {
            int currentPosition = this.position();
            this.position = new Position(currentPosition + 1);
        }
    }

    private static class Position {
        private final int position;

        public Position(int position) {
            this.position = position;
        }

        public int position() {
            return this.position;
        }
    }

}
