package study.step_3;

public class Input {
    private int numberOfCars;
    private int numberOfTrial;

    public Input(String numberOfCars, String numberOfTrial) {
        this(Integer.parseInt(numberOfCars), Integer.parseInt(numberOfTrial));
    }

    public Input(int numberOfCars, int numberOfTrial) {
        this.numberOfCars = numberOfCars;
        this.numberOfTrial = numberOfTrial;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfTrial() {
        return numberOfTrial;
    }
}
