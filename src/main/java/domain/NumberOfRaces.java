package domain;

public class NumberOfRaces {
    private final int number;
    public NumberOfRaces(int number) {
        if (number < 0)
            throw new RuntimeException("CarNumber can not be negative");
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
