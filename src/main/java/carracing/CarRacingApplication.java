package carracing;

public class CarRacingApplication {
    public static void main(String[] args) {
        new CarRacingGame(new InputView(), new OutputView()).start();
    }
}
