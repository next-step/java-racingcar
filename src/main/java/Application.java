public class Application {
    public static void main(String[] args) {
        String cars = InputView.readCarNameInput();
        int roundCount = InputView.readRoundCountInput();

        RaceController controller = new RaceController(CarsFactory.createCars(cars), roundCount);
        controller.start();
    }
}
