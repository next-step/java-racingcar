package step4.model;

import java.util.Objects;

public class Position implements Comparable<Position>{
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position += 1;
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
    public int compareTo(Position that) {
        if (this.position > that.position) {
            return 1;
        }else if (this.position == that.position){
            return 0;
        }else {
            return -1;
        }
    }

}
