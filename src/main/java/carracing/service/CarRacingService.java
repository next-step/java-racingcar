package carracing.service;

import carracing.constants.CarRacingConstant;
import carracing.domain.Car;
import carracing.domain.CarService;
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
        _validate(racingRegisterInfo);
        return _getRacingResult(racingRegisterInfo.getRoundCount(), _registerPlayers(racingRegisterInfo.getRacingCarCount()));
    }

    private void _validate(RacingRegisterInfo racingRegisterInfo) {
        carRacingValidator.validateCarRegisterCount(racingRegisterInfo.getRacingCarCount());
        carRacingValidator.validateRoundCount(racingRegisterInfo.getRoundCount());
    }

    private Players _registerPlayers(int racingCarCount) {
        Players players = new Players();
        for (int i = CarRacingConstant.FIRST_CAR_NUMBER; i <= racingCarCount; i++) {
            players.registerPlayer(carService.registerCar(i));
        }
        return players;
    }

    private RacingResult _getRacingResult(int roundCount, Players players) {
        RacingResult racingResult = new RacingResult();
        for (int i = CarRacingConstant.ROUND_START_NUMBER; i <= roundCount; i++) {
            racingResult.registerRoundResult(_executeRound(i, players));
        }
        return racingResult;
    }

    private RoundResult _executeRound(int roundNumber, Players players) {
        RoundResult roundResult = new RoundResult();
        roundResult.registerRoundResult(roundNumber, _executeScoring(players));
        return roundResult;
    }

    private RacingScores _executeScoring(Players players) {
        RacingScores racingScores = new RacingScores();
        for (Car car : players.getCarList()) {
            car.drive();
            racingScores.registerRacingScore(car);
        }
        return racingScores;
    }
}
