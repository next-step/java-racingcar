package racing;

public class RacingGame {
    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int retryCount = InputView.getRetryCount();
        Car car = new Car(carCount);
        car.start(retryCount);
    }
}
