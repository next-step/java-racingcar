package racing;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void add(int addend) {
        position += addend;
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
