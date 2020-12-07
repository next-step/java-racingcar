package racing;

public class RacingApplication {
    public static void main(String[] args) {
        Cars cars = new Cars(InputView.numberOfCars(), new RandomCondition());
        Racing racing = new Racing(InputView.tryTimes(), cars);
        racing.start();
    }
}
