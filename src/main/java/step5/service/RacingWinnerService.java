package step5.service;

import java.util.List;
import java.util.stream.Collectors;
import step5.domain.RacingResult;

public class RacingWinnerService {

    public static String chooseWinner(List<RacingResult> racingResults) {
        int foreFrontLocation = getForeFrontLocation(racingResults);

        return racingResults.stream()
                .filter(car -> car.getLocation() == foreFrontLocation)
                .map(RacingResult::getCarName)
                .collect(Collectors.joining(","));
    }

    private static int getForeFrontLocation(List<RacingResult> cars) {
        return cars.stream()
                .mapToInt(car -> car.getLocation())
                .max()
                .getAsInt();
    }
}
