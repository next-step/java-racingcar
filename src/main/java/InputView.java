import java.util.Scanner;

public class InputView {

    private int numberOfCars;
    private int numberOfAttempts;

    public InputView() {
    }

    public InputView(int numberOfCars, int numberOfAttempts) {
        this.numberOfCars = numberOfCars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }
}
