package motorRace;

import java.util.Random;

// 경주를 수행하는 책임
public class RaceService {
    private static final Random random = new Random();

    public RaceResult race(RacingCars racingCars, int moveCnt){
        RaceResult raceResult = new RaceResult();
        for (int i = 0; i < moveCnt ; i++) {
            oneStepRace(racingCars);
            raceResult.saveRound(racingCars);
        }
        return raceResult;
    }

    private void oneStepRace(RacingCars racingCars){
        racingCars.getRacingCarList().forEach(
                racingCar -> {
                    racingCar.move(random.nextInt(10));
                }
        );
    }
}
