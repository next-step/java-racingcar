package racingcarwinner;

public class Position {

    private final int value;

    public Position(final int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public int getIncreaseValue(){
        return this.value + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return value == position.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
