package racingcar.domain;

public class Position {
    private final int position;

    public Position(final int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionString() {
        StringBuilder sb = new StringBuilder();
        for (int index=0; index<this.position; index++) {
            sb.append('-');
        }
        return sb.toString();
    }

    public int greaterThan(int maxPosition) {
        if (this.position > maxPosition) {
            return this.position;
        }
        return maxPosition;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }
}

