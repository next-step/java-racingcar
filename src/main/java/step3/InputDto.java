package step3;

public class InputDto {

    public int numberOfCar;
    public int numberOfTrial;

    public InputDto(int numberOfCar, int numberOfTrial) {
        this.numberOfCar = numberOfCar;
        this.numberOfTrial = numberOfTrial;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getNumberOfTrial() {
        return numberOfTrial;
    }
}
