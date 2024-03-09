package racing;

public class Position {
    private static final int START_POSITION = 0;
    private static final String DASH = "-";

    private int position;

    public Position() {
        this.position = START_POSITION;
    }

    public void addOne() {
        position++;
    }

    public String dashOfPosition() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(DASH);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            return position == ((Position) obj).position;
        }
        return false;
    }
}
