package stringcalculator.domain;

public class Positive {

    private int number;

    public Positive(String numberString) {
        this.number = Integer.parseInt(numberString);
        if (this.number < 0) throw new RuntimeException();
    }

    public int parseInt() {
        return this.number;
    }

}
