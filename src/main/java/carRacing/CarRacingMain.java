package carRacing;


public class CarRacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.printNumberOfCars();
        int numberOfCars = inputView.inputNumber();

        inputView.printNumberOfRacing();
        int numberOfRacing = inputView.inputNumber();

        CarRacing racing = new CarRacing();
        racing.start(numberOfCars, numberOfRacing);
    }
}
