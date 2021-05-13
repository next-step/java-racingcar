package racegame;

import java.util.Map;

public class RacingGameRenewal {

    public int RacingGame(RacingCar car) {
        int randomNummer = (int) (Math.random() * 10);
        if (randomNummer >= 4) {
            goStep(car);
        }
        checkPrint(car);
        return car.getGoStep();
    }

    void goStep(RacingCar car) {
        int goOne = car.getGoStep() + 1;
        car.setGoStep(goOne);
    }

    void checkPrint(RacingCar car) {
        int goStep = car.getGoStep();
        String goString = "";
        for (int i = 0; i < goStep; i++) {
            goString += "-";
        }
        System.out.println(car.getCarName() + ":" + goString);
    }
}
