package carracing.service.dto;

import carracing.domain.Car;
import carracing.domain.Cars;

import java.util.ArrayList;
import java.util.List;

/**
 * RacingResult
 * description 레이싱 경기결과
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) 생성자 추가 (도메인로직을 포함한 빌드)
 */
public class RacingResult {

    private static final int ROUND_START_NUMBER = 1;

    private final List<RoundResult> roundResultList = new ArrayList<>();

    public List<RoundResult> getRoundResultList() {
        return roundResultList;
    }

    public RacingResult(int roundCount, Cars cars) {
        for (int i = ROUND_START_NUMBER; i <= roundCount; i++) {
            roundResultList.add(executeRound(i, cars));
        }
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
