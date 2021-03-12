package carracing.service;

import carracing.constants.CarRacingConstant;
import carracing.domain.Car;
import carracing.domain.CarService;
import carracing.domain.Cars;
import carracing.service.dto.*;

/**
 * CarRacingService
 * description 자동차 경주 서비스
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class CarRacingService {

    private CarService         carService;
    private CarRacingValidator carRacingValidator;

    public CarRacingService() {
        this.carService = new CarService();
        this.carRacingValidator = new CarRacingValidator();
    }

    public RacingResult executeCarRacing(RacingRegisterInfo racingRegisterInfo) {
        validate(racingRegisterInfo);
        return getRacingResult(racingRegisterInfo.getRoundCount(), carService.registerCars(racingRegisterInfo.getRacingCarCount()));
    }

    private void validate(RacingRegisterInfo racingRegisterInfo) {
        carRacingValidator.validateCarRegisterCount(racingRegisterInfo.getRacingCarCount());
        carRacingValidator.validateRoundCount(racingRegisterInfo.getRoundCount());
    }

    private RacingResult getRacingResult(int roundCount, Cars cars) {
        RacingResult racingResult = new RacingResult();
        for (int i = CarRacingConstant.ROUND_START_NUMBER; i <= roundCount; i++) {
            racingResult.registerRoundResult(executeRound(i, cars));
        }
        return racingResult;
    }

    private RoundResult executeRound(int roundNumber, Cars cars) {
        return new RoundResult(roundNumber, executeScoring(cars));
    }

    private RacingScores executeScoring(Cars cars) {
        RacingScores racingScores = new RacingScores();
        for (Car car : cars.getCarList()) {
            car.drive();
            racingScores.registerRacingScore(car);
        }
        return racingScores;
    }
}
