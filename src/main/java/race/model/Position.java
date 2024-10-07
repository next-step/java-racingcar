package race.model;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        this.position++;
    }

    public boolean hasSamePosition(int otherPosition) {
        return this.position == otherPosition;
    }

    public int findMaxValue(int maxValue) {
        return Math.max(maxValue, this.position);
    }

    public void drawForwardDistance(String forwardString) {
        System.out.print(forwardString.repeat(this.position));
    }
}
