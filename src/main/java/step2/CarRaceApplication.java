package step2;

public class CarRaceApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        final int numberOfCars = inputView.getNumberOfCars();
        final int numberOfTrials = inputView.getNumberOfTrials();

        CarRace carRace = new CarRace(numberOfCars, numberOfTrials);
        carRace.start();
    }


}
