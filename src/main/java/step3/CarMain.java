package step3;

public class CarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        CarController controller = new CarController();

        int numberOfCars = inputView.numberOfCars();
        int tryCounts = inputView.tryCount();
        
        controller.start(numberOfCars, tryCounts);
    }
}
