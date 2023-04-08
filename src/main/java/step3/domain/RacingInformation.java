package step3.domain;

public class RacingInformation {

    private final int numberOfCars;
    private final int numberOfReps;

    private RacingInformation(int numberOfCars, int numberOfReps) {
        this.numberOfCars = numberOfCars;
        this.numberOfReps = numberOfReps;

    }

    public static RacingInformation of(int numberOfCars, int numberOfReps) {
        return new RacingInformation(numberOfCars, numberOfReps);
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfReps() {
        return numberOfReps;
    }
}
