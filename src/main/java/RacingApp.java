public class RacingApp {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.inputNumberOfCars();
        int round = inputView.inputRound();

        Car[] cars = CarFactory.createCars(numberOfCars);

        Racing racing = new Racing(cars, round);
        racing.start();
    }

}
