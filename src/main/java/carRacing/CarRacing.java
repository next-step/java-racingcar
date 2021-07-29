package carRacing;

public class CarRacing {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.printNumberOfCars();
        int numberOfCars = inputView.inputNumber();
        System.out.println(numberOfCars);

        inputView.printNumberOfRacing();
        int numberOfRacing = inputView.inputNumber();
        System.out.println(numberOfRacing);
    }
}
