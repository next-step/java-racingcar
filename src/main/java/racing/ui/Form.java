package racing.ui;

public class Form {
    private final int numberOfCars;
    private final int numberOfPlays;

    public Form(int numberOfCars, int numberOfPlays) {
        this.numberOfCars = numberOfCars;
        this.numberOfPlays = numberOfPlays;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfPlays() {
        return numberOfPlays;
    }
}
