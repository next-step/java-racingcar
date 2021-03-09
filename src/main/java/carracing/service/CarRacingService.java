package carracing.service;

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

    private static final int MIN_CAR_REGISTER_NUMBER = 1;
    private static final int MIN_ROUND_NUMBER = 1;
    private static final int FIRST_CAR_NUMBER = 1;
    private static final int ROUND_START_NUMBER = 1;

    CarService carService;

    public CarRacingService() {
        this.carService = new CarService();
    }

    public RacingResult executeCarRacing(RacingRegisterInfo racingRegisterInfo) {
        _validate(racingRegisterInfo);
        return _getRacingResult(racingRegisterInfo.getRoundCount(), _registerPlayers(racingRegisterInfo.getRacingCarCount()));
    }

    private void _validate(RacingRegisterInfo racingRegisterInfo) {
        if(racingRegisterInfo.getRacingCarCount() < MIN_CAR_REGISTER_NUMBER) {
            throw new IllegalArgumentException("자동차 등록수는 최소 한 대 이상이어야 합니다.");
        }
        if(racingRegisterInfo.getRoundCount() < MIN_ROUND_NUMBER) {
            throw new IllegalArgumentException("경기 횟수는 최소 1회 이상이어야 합니다.");
        }
    }

    private Players _registerPlayers(int racingCarCount) {
        Players players = new Players();
        for (int i = FIRST_CAR_NUMBER; i <= racingCarCount; i++) {
            players.registerPlayer(carService.registerCar(i));
        }
        return players;
    }

    private RacingResult _getRacingResult(int roundCount, Players players) {
        RacingResult racingResult = new RacingResult();
        for (int i = ROUND_START_NUMBER; i <= roundCount; i++) {
            racingResult.registerRoundResult(_executeRound(i, players));
        }
        return racingResult;
    }

    private RoundResult _executeRound(int roundNumber, Players players) {
        RoundResult roundResult = new RoundResult();
        roundResult.setRoundNumber(roundNumber);
        roundResult.setRacingScores(_executeScoring(players));
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
