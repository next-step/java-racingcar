package carracing.service;

import carracing.controller.dto.CarRacingRequest;
import carracing.domain.Cars;
import carracing.service.dto.RacingResult;

/**
 * CarRacingService
 * description 자동차 경주 서비스
 * version 0.0.2
 *
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) validator 클래스 제거 (도메인 클래스를 활용해 검증)
 */
public class CarRacingService {

    public RacingResult executeCarRacing(CarRacingRequest carRacingRequest) {
        return new RacingResult(carRacingRequest.getRoundCount(), new Cars(carRacingRequest.getRacingCarCount()));
    }
}
