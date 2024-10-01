package carracing;

public class CarRacingInterface {
    public static void start() {
        int carCount = InputView.carCountFromUser();
        int moveTryCount = InputView.moveTryCountFromUser();
        CarRacing carRacing = CarRacing.builder()
                .cars(carCount)
                .moveTryCount(moveTryCount)
                .build();

        carRacing.start();
    }

    public static void main(String[] args) {
        CarRacingInterface.start();
    }
}
