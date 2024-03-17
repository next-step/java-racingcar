package race.domain;

import java.util.Objects;

public class Position {

    private int number;

    public Position(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(String.format("(%s)은 음수입니다. 차의 위치(position)는 0이상의 양의 정수만 허용됩니다.", number));
        }
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void increase() {
        this.number++;
    }

    public int maxComparedTo(int otherNumber) {
        if (otherNumber > this.number) {
            return otherNumber;
        }
        return this.number;
    }

    public boolean isWinner(int maxNumber) {
        return this.number == maxNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return number == position1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
