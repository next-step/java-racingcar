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
        validate(racingRegisterInfo);
        return getRacingResult(racingRegisterInfo.getRoundCount(), registerPlayers(racingRegisterInfo.getRacingCarCount()));
    }

    private void validate(RacingRegisterInfo racingRegisterInfo) {
        carRacingValidator.validateCarRegisterCount(racingRegisterInfo.getRacingCarCount());
        carRacingValidator.validateRoundCount(racingRegisterInfo.getRoundCount());
    }

    private Players registerPlayers(int racingCarCount) {
        Players players = new Players();
        for (int i = CarRacingConstant.FIRST_CAR_NUMBER; i <= racingCarCount; i++) {
            players.registerPlayer(carService.registerCar(i));
        }
        return players;
    }

    private RacingResult getRacingResult(int roundCount, Players players) {
        RacingResult racingResult = new RacingResult();
        for (int i = CarRacingConstant.ROUND_START_NUMBER; i <= roundCount; i++) {
            racingResult.registerRoundResult(executeRound(i, players));
        }
        return racingResult;
    }

    private RoundResult executeRound(int roundNumber, Players players) {
        RoundResult roundResult = new RoundResult();
        roundResult.registerRoundResult(roundNumber, executeScoring(players));
        return roundResult;
    }

    private RacingScores executeScoring(Players players) {
        RacingScores racingScores = new RacingScores();
        for (Car car : players.getCarList()) {
            car.drive();
            racingScores.registerRacingScore(car);
        }
        return racingScores;
    }
}
