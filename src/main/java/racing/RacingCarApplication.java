package racing;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.requestNumberOfCar();
        int numberOfMove = inputView.requestNumberOfMove();
    }
}
