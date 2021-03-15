package carracing.service;

import carracing.constants.CarRacingConstant;
import carracing.domain.Cars;
import carracing.service.dto.RacingResult;
import carracing.service.dto.RacingScore;
import carracing.service.dto.RacingScores;
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
        if(cars==null || cars.getCarList().size()==0) {
            throw new IllegalArgumentException("차량정보를 입력해 주세요.");
        }
    }

    public RacingResult executeRacing() {
        return new RacingResult(executeAllRound(), chooseWinner(cars.inquiryRacingScores()));
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

    private RacingScores executeScoring(Cars cars) {
        cars.driveAll();
        return cars.inquiryRacingScores();
    }

    private List<String> chooseWinner(RacingScores inquiryRacingScores) {
        int winnerScore = 0;
        List<String> winnerList = new ArrayList<>();
        for (RacingScore racingScore : inquiryRacingScores.getRacingScoreList()) {
            winnerList  = decideWinnerList(winnerScore, winnerList, racingScore);
            winnerScore = decideWinnerScore(winnerScore, racingScore);
        }
        return winnerList;
    }

    private List<String> decideWinnerList(int currentWinnerScore, List<String> winnerList, RacingScore racingScore) {
        if(currentWinnerScore < racingScore.getScore()) {
            return replaceWinner(winnerList, racingScore.getCarName());
        }
        if(currentWinnerScore == racingScore.getScore()) {
            return addWinner(winnerList, racingScore.getCarName());
        }
        return winnerList;
    }

    private List<String> replaceWinner(List<String> winnerList, String carName) {
        winnerList.clear();
        winnerList.add(carName);
        return winnerList;
    }

    private List<String> addWinner(List<String> winnerList, String carName) {
        winnerList.add(carName);
        return winnerList;
    }

    private int decideWinnerScore(int currentWinnerScore, RacingScore racingScore) {
        return Math.max(currentWinnerScore, racingScore.getScore());
    }
}
