package step3;

public class RacingController {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final int carCount = inputView.numberOfCar();
        final int times = inputView.numberOfAttempts();
    }
}
