package step3;

import step3.dto.CarStatusDto;
import step3.dto.RacingResultDto;
import step3.view.ResultView;

import java.util.List;

public class CarRacingController {

    private CarRacingService carRacingService;

    public CarRacingController(int carNumbers, MoveStrategy moveStrategy) {
        this.carRacingService = new CarRacingService(carNumbers, moveStrategy);
    }

    public void racingStart(int attemptCount) {
        RacingResultDto resultDto = carRacingService.executeRacing(attemptCount);

        for (List<CarStatusDto> attemptResult : resultDto.getAttempts()) {
            ResultView.displayCurrentCarsLocation(attemptResult);
        }
    }
}
