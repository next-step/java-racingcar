package carracing.service;

import carracing.domain.Cars;
import carracing.service.dto.RacingRegisterInfo;
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

    private CarRacingValidator carRacingValidator;

    public CarRacingService() {
        this.carRacingValidator = new CarRacingValidator();
    }

    public RacingResult executeCarRacing(RacingRegisterInfo racingRegisterInfo) {
        validate(racingRegisterInfo);
        return new RacingResult(racingRegisterInfo.getRoundCount(), new Cars(racingRegisterInfo.getRacingCarCount()));
    }

    private void validate(RacingRegisterInfo racingRegisterInfo) {
        carRacingValidator.validateCarRegisterCount(racingRegisterInfo.getRacingCarCount());
        carRacingValidator.validateRoundCount(racingRegisterInfo.getRoundCount());
    }

}
