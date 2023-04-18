package domain;

public class NumberOfRaces {
    public final static int MIN_VALUE = 0;
    private final int value;
    public NumberOfRaces(int value) {
        if (value < MIN_VALUE) {
            throw new RuntimeException("NumberOfRaces can not be negative");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
