package racingCar.step5.view;

import racingCar.step4.RacingCar;
import racingCar.step4.RacingCars;
import racingCar.step5.domain.dto.RaceResult;
import racingCar.step5.domain.dto.WinnerDto;

import java.util.ArrayList;
import java.util.List;

public interface ResultView {
    public void showRaceResults(List<RaceResult> raceResults);
    public void showRaceChampion(List<WinnerDto> winners);
}
