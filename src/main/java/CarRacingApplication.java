import config.AppConfig;
import controller.CarRacingController;

public class CarRacingApplication {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        CarRacingController carRacingController = appConfig.carRacingController();
        carRacingController.startRacingGame();
    }
}
