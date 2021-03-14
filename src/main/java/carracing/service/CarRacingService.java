package carracing.service;

import carracing.controller.dto.CarRacingRequest;
import carracing.domain.Cars;
import carracing.service.dto.RacingResult;

/**
 * CarRacingService
 * description 자동차 경주 서비스
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class CarRacingService {

    private final CarRacingValidator carRacingValidator;

    public CarRacingService() {
        this.carRacingValidator = new CarRacingValidator();
    }

    public RacingResult executeCarRacing(CarRacingRequest carRacingRequest) {
        validate(carRacingRequest);
        return new RacingResult(carRacingRequest.getRoundCount(), new Cars(carRacingRequest.getRacingCarCount()));
    }

    private void validate(CarRacingRequest carRacingRequest) {
        carRacingValidator.validateCarRegisterCount(carRacingRequest.getRacingCarCount());
        carRacingValidator.validateRoundCount(carRacingRequest.getRoundCount());
    }

}
