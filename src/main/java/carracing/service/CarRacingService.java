package carracing.service;

import carracing.domain.Car;
import carracing.domain.CarService;
import carracing.service.dto.RacingScore;
import carracing.service.dto.RacingRegisterInfo;
import carracing.service.dto.RoundResult;

import java.util.ArrayList;
import java.util.List;

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

    public List<RoundResult> executeCarRacing(RacingRegisterInfo racingRegisterInfo) {

        _validate(racingRegisterInfo);

        List<RoundResult> roundResultList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();

        for (int i = FIRST_CAR_NUMBER; i <= racingRegisterInfo.getRacingCarCount(); i++) {
            carList.add(carService.registerCar(i));
        }
        for (int i = ROUND_START_NUMBER; i <= racingRegisterInfo.getRoundCount(); i++) {
            roundResultList.add(_executeRound(i, carList));
        }

        return roundResultList;
    }

    private void _validate(RacingRegisterInfo racingRegisterInfo) {
        if(racingRegisterInfo.getRacingCarCount() < MIN_CAR_REGISTER_NUMBER) {
            throw new IllegalArgumentException("자동차 등록수는 최소 한 대 이상이어야 합니다.");
        }
        if(racingRegisterInfo.getRoundCount() < MIN_ROUND_NUMBER) {
            throw new IllegalArgumentException("경기 횟수는 최소 1회 이상이어야 합니다.");
        }
    }

    private RoundResult _executeRound(int roundNumber, List<Car> carList) {
        RoundResult roundResult = new RoundResult();
        roundResult.setRoundNumber(roundNumber);
        roundResult.setRacingScoreList(_executeScoring(carList));
        return roundResult;
    }

    private List<RacingScore> _executeScoring(List<Car> carList) {
        List<RacingScore> racingScoreList = new ArrayList<>();
        for (Car car : carList) {
            car.drive();
            RacingScore racingScore = new RacingScore();
            racingScore.setCarNbr(car.getCarNumber());
            racingScore.setScore(car.getMileage());
            racingScoreList.add(racingScore);
        }
        return racingScoreList;
    }
}
