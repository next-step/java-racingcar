package study.racing;

import study.racing.controller.CarRacingController;
import study.racing.domain.RacingRecords;

public class CarRacingMain {

    public static void main(String args[]){
        String[] carNames = CarRacingController.getCarsName();
        int tryCount = CarRacingController.getTryCount();
        RacingRecords racingResults  = CarRacingController.execute(carNames, tryCount);
        CarRacingController.showResult(racingResults);
    }
}

