package carRacing;


public class CarRacingMain {
    public static void main(String[] args) {
        InputView.printNumberOfCars();
        int numberOfCars = InputView.inputNumber();

        InputView.printNumberOfRacing();
        int numberOfRacing = InputView.inputNumber();

        CarRacing racing = new CarRacing();
        racing.start(numberOfCars, numberOfRacing);
    }
}
