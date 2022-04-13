package racingcar;

public class Position implements Comparable<Position> {
    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void add() {
        position++;
    }

    public boolean checkPosition(int checkPosition) {
        return position == checkPosition;
    }

    public boolean isEqualPosition(Position comparePosition) {
        return position == comparePosition.position;
    }

    public String positionToExpression(String moveExpression) {
        String expression = "";
        for (int i = 0; i < position; i++) {
            expression += moveExpression;
        }
        return expression;
    }

    @Override
    public int compareTo(Position comparePosition) {
        return position - comparePosition.position;
    }
}
