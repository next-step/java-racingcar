package carracing.controller;

import carracing.controller.dto.CarRacingRequest;
import carracing.service.CarRacingService;
import carracing.service.dto.RacingResult;

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

    public RacingResult executeCarRacing(CarRacingRequest carRacingRequest) {
        return carRacingService.executeCarRacing(carRacingRequest);
    }
}
