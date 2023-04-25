package racing.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position){
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    public String getPositionDash() {
        String dash = "";
        for (int i = 0; i < position; i++) {
            dash += "-";
        }
        return dash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
