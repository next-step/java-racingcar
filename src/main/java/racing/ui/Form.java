package racing.ui;

public class Form {
    public static final String CAR_NAMES_SEPARATOR = ",";
    private final String[] nameOfCars;
    private final int numberOfPlays;

    public Form(String nameOfCars, int numberOfPlays) {
        this.nameOfCars = nameOfCars.split(CAR_NAMES_SEPARATOR);
        this.numberOfPlays = numberOfPlays;
    }

    public String[] getNameOfCars() {
        return nameOfCars;
    }

    public int getNumberOfPlays() {
        return numberOfPlays;
    }
}
