package racing;

public class Position {
    private static final int START_POSITION = 0;

    private int position;

    public Position() {
        this.position = START_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public void addOne() {
        position++;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            return position == ((Position) obj).position;
        }
        return false;
    }

    public String dashOfPosition() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
