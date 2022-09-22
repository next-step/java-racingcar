package step2;

public class Positive {
    private final int number;

    public Positive(String value) {
        this(Integer.parseInt(value));
    }

    public Positive(int value) {
        if (value < 0) {
            throw new RuntimeException("Can not negative");
        }
        this.number = value;
    }

    public int getNumber() {
        return this.number;
    }

    public Positive plus(Positive value) {
        return new Positive(this.number + value.getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.number == ((Positive) o).number;
    }
}
