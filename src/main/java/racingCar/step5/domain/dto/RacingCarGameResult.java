package racingCar.step5.domain.dto;

import racingCar.step5.domain.RacingCar;
import racingCar.step5.domain.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameResult {

    public static List<RaceResult> raceResultFrom(List<RacingCars> raceResults) {
        List<RaceResult> racingResults = new ArrayList<>();

        for (RacingCars race : raceResults) {
            RaceResult raceResult = getRaceResult(race);
            racingResults.add(raceResult);
        }
        return racingResults;
    }

    private static RaceResult getRaceResult(RacingCars race) {
        RaceResult raceResult = new RaceResult();
        for(RacingCar car : race.getCars()){
            CarDto carDto = CarDto.of(car);
            raceResult.add(carDto);
        }
        return raceResult;
    }

    public static List<WinnerDto> winnersFrom(List<RacingCar> winnerCars) {
        List<WinnerDto> winners = new ArrayList<>();
        for (RacingCar winnerCar : winnerCars) {
            WinnerDto winnerInfo = WinnerDto.of(winnerCar);
            winners.add(winnerInfo);
        }
        return winners;
    }
}
