package carracing.controller;

import carracing.controller.dto.CarRacingRequest;
import carracing.controller.dto.CarRacingResponse;
import carracing.domain.Car;
import carracing.service.CarRacingService;
import carracing.service.dto.RacingResult;

import java.util.ArrayList;
import java.util.List;

/**
 * CarRacingController
 * description 자동차 경주 API
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class CarRacingController {

    private final CarRacingService carRacingService;

    public CarRacingController() {
        this.carRacingService = new CarRacingService();
    }

    public CarRacingResponse executeCarRacing(CarRacingRequest carRacingRequest) {
        return assembleOutput(carRacingService.executeCarRacing(carRacingRequest));
    }

    private CarRacingResponse assembleOutput(RacingResult racingResult) {
        List<String> winnerNameList = new ArrayList<>();
        for (Car car : racingResult.getWinnerList()) {
            winnerNameList.add(car.getName());
        }
        return new CarRacingResponse(racingResult.getRoundResultList(), winnerNameList);
    }
}
