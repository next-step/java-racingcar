package carracing.service;

import carracing.constants.CarRacingConstant;
import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.service.dto.RacingResult;
import carracing.service.dto.RacingScore;
import carracing.service.dto.RoundResult;

import java.util.ArrayList;
import java.util.List;

/**
 * CarRacing
 * version 0.0.2
 *
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) 우승자 판별로직 추가
 */
public class CarRacing {

    private static final int ROUND_START_NUMBER = 1;

    private final int roundCount;
    private final Cars cars;

    public CarRacing(int roundCount, Cars cars) {
        validateRoundCount(roundCount);
        validateCars(cars);
        this.roundCount = roundCount;
        this.cars = cars;
    }

    private void validateRoundCount(int roundCount) {
        if(roundCount < CarRacingConstant.MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("경기 횟수는 최소 1회 이상이어야 합니다.");
        }
    }

    private void validateCars(Cars cars) {
        if(cars==null) {
            throw new IllegalArgumentException("차량정보를 입력해 주세요.");
        }
    }

    public RacingResult executeRacing() {
        return new RacingResult(executeAllRound(), cars.chooseWinners());
    }

    private List<RoundResult> executeAllRound() {
        List<RoundResult> roundResultList = new ArrayList<>();
        for (int i = ROUND_START_NUMBER; i <= roundCount; i++) {
            roundResultList.add(executeRound(i));
        }
        return roundResultList;
    }

    private RoundResult executeRound(int roundNumber) {
        return new RoundResult(roundNumber, executeScoring(cars));
    }

    private List<RacingScore> executeScoring(Cars cars) {
        cars.driveAll();
        return cars.racingScoreList();
    }

    private List<String> getNameList(List<Car> winners) {
        List<String> winnerNameList = new ArrayList<>();
        for (Car winner : winners) {
            winnerNameList.add(winner.getName());
        }
        return winnerNameList;
    }

}
