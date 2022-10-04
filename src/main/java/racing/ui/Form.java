package racing.ui;

public class Form {
    private final String[] nameOfCars;
    private final int numberOfPlays;

    public Form(String nameOfCars, int numberOfPlays) {
        this.nameOfCars = nameOfCars.split(",");
        this.numberOfPlays = numberOfPlays;
    }

    public String[] getNameOfCars() {
        return nameOfCars;
    }

    public int getNumberOfPlays() {
        return numberOfPlays;
    }
}
