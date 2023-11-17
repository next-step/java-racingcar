package study.racingCar;

import java.util.Objects;

public class Position {

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int num){
        this.position = num;
    }

    public void print() {
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
    }

    public Position increase(int num){
        if (num>3){
            return new Position(this.position+1);
        }
        return this;
    }

    public boolean isBiggerThan(Position p){
        return this.position > p.position;
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
}
