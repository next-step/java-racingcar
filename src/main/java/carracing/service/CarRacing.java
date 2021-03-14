package carracing.service;

import carracing.constants.CarRacingConstant;
import carracing.domain.Cars;
import carracing.service.dto.RacingResult;
import carracing.service.dto.RacingScores;
import carracing.service.dto.RoundResult;

import java.util.ArrayList;
import java.util.List;

/**
 * CarRacing
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
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
        if(cars==null || cars.getCarList().size()==0) {
            throw new IllegalArgumentException("차량정보를 입력해 주세요.");
        }
    }

    public RacingResult executeRacing() {
        List<RoundResult> roundResultList = new ArrayList<>();
        for (int i = ROUND_START_NUMBER; i <= roundCount; i++) {
            roundResultList.add(executeRound(i, cars));
        }
        return new RacingResult(roundResultList);
    }

    private RoundResult executeRound(int roundNumber, Cars cars) {
        return new RoundResult(roundNumber, executeScoring(cars));
    }

    private RacingScores executeScoring(Cars cars) {
        cars.driveAll();
        return cars.inquiryRacingScores();
    }
}
