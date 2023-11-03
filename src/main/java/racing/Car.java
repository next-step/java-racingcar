package racing;

public class Car {
    private Position position;

    public Car() {
        this.position = new Position(0);
    }
    public int position() {
        return position.position();
    }

    public void move(int input) {
        if (4 <= input) {
            int prevPosition = this.position();
            this.position = new Position(prevPosition + 1);
        }
    }

    private class Position {
        private int position;

        public Position(int position) {
            this.position = position;
        }

        public int position() {
            return this.position;
        }
    }

}
