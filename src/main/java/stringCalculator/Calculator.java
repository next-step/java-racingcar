package stringCalculator;

public class Calculator {

    private int total;

    public Calculator() {
        this.total = 0;
    }

    public Calculator(int number) {
        this.total = number;
    }

    public Calculator initialize(int number) {
        this.total = number;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public Calculator add(int number) {
        this.total +=  number;
        return this;
    }

    public Calculator subtract(int number) {
        this.total = this.total - number;
        return this;
    }

    public Calculator multiply(int number) {
        this.total = this.total * number;
        return this;
    }

    public Calculator divide(int number) {
        this.total = this.total / number;
        return this;
    }
}
