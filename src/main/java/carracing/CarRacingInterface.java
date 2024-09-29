package carracing;

public class CarRacingInterface {
    public static void start() {
        CarRacing carRacing = CarRacing.builder()
                .cars(InputView.carCountFromUser())
                .moveTryCount(InputView.moveTryCountFromUser())
                .build();

        carRacing.start();
    }

    public static void main(String[] args) {
        CarRacingInterface.start();
    }
}
