package racingcar.domain;

import java.util.Objects;

public class Position implements Cloneable {

    private int value;

    public Position() {
        this.value = 0;
    }

    public Position(int value) {
        this.value = value;
    }

    public void forward() {
        this.value += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<value ; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
