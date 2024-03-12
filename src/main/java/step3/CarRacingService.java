package step3;

import step3.dto.CarStatusDto;
import step3.dto.RacingResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingService {

    private CarRacing carRacing;

    public CarRacingService(int carNumbers, String[] carNames, MoveStrategy moveStrategy) {
        this.carRacing = new CarRacing(carNumbers, carNames, moveStrategy);
    }

    public RacingResultDto executeRacing(int attemptCount) {
        List<List<CarStatusDto>> racingResults = new ArrayList<>();

        for (int i = 0; i < attemptCount; i++) {
            carRacing.moveCars();
            List<CarStatusDto> currentAttemptStatus = carRacing.getCars().stream()
                    .map(car -> new CarStatusDto(car.getCurrentLocation()))
                    .collect(Collectors.toList());
            racingResults.add(currentAttemptStatus);
        }

        return new RacingResultDto(racingResults);
    }
}
