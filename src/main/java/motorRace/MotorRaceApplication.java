package motorRace;

import static motorRace.InputView.*;
import static motorRace.ResultView.raceResultOut;

public class MotorRaceApplication {
    public static void main(String[] args) {
        RacingCarFactory racingCarFactory = new RacingCarFactory();
        RaceService raceService = new RaceService();

        int carCnt = carCntIn();
        RacingCars racingCars = racingCarFactory.makeRacingCars(carCnt);

        int moveCnt = moveCntIn();
        RaceResult raceResult = raceService.race(racingCars,moveCnt);

        raceResultOut(raceResult);
    }
}
