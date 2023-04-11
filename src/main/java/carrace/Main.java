package carrace;

public class Main {

    public static void main(String[] args) {
        final int numberOfCars = InputView.HOW_MANY_CARS.getAnswer();
        final int numberOfLabs = InputView.HOW_MANY_LABS.getAnswer();

        Cars cars = new Cars(numberOfCars);
        final CarRace carRace = new CarRace(cars, numberOfLabs);
        carRace.start();

        ResultView.print(carRace);
    }
}
