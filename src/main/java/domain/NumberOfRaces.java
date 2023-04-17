package domain;

public class NumberOfRaces {
    private final int value;
    private final static int MIN_VALUE = 0;
    public NumberOfRaces(int value) {
        if (value < 0)
            throw new RuntimeException("NumberOfRaces can not be negative");
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
