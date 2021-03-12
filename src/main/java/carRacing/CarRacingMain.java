package carRacing;

import carRacing.service.CarRacingService;

public class CarRacingMain {
    public static void main(String[] args){
        CarRacingService carRacingProgram = new CarRacingService();
        carRacingProgram.run();
    }
}
