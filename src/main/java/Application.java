public class Application {
    public static void main(String[] args) {
        Cars cars = CarsFactory.createCars(InputView.readCarNameInput());
        int roundCount = InputView.readRoundCountInput();

        ResultView.printResultHeader();
        RaceController controller = new RaceController(cars, roundCount);
        controller.start();
    }
}
