package domain;

public class Position implements Comparable<Position> {
    private static final String MOVE_EXPRESSION = "-";
    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        this.position = position;
    }

    public Position(Position position) {
        this.position = position.position;
    }

    public void add() {
        position++;
    }

    @Override
    public String toString() {
        String expression = "";
        for(int i = 0; i<position; i++) {
            expression += MOVE_EXPRESSION;
        }
        return expression;
    }

    public boolean isEqualPosition(Position comparePosition) {
        return position == comparePosition.position;
    }

    @Override
    public int compareTo(Position comparePosition) {
        return position - comparePosition.position;
    }
}
