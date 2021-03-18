package carRacing;

import carRacing.service.CarRacingService;

public class CarRacingMain {

    public static void main(String[] args) {
        CarRacingService carRacingService = new CarRacingService();
        carRacingService.run();
    }
}
