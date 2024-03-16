package race.domain;

public class Position implements Comparable<Position> {

    private int value;

    public static Position createInstance(int number) {
        return new Position(number);
    }

    private Position(int value) {
        this.value = value;
    }


    public void increase() {
        value++;
    }

    public int getValue() {
        return value;
    }

    public boolean isEqual(Position position) {
        return value == position.getValue();
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(value, o.getValue());
    }
}
