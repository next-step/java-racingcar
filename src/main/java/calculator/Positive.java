package calculator;


public class Positive {

    private final int number;

    public Positive(String numberStr) {
        try {
            this.number = Integer.parseInt(numberStr);
        } catch (NumberFormatException nfe) {
            throw new InvalidPositiveNumberFormatException();
        }

        if (this.number < 0) {
            throw new InvalidPositiveNumberFormatException();
        }
    }

    private Positive(int number) {
        this.number = number;
    }

    public Positive() {
        this(0);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Positive sum(Positive positive) {
        return new Positive(this.number + positive.number);
    }
}
