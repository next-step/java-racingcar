package racinggame.domain.racing;

import racinggame.util.NumberUtil;

import java.util.List;

/**
 * 1. Car의 List 필드
 * 1. 레이싱 1 라운드를 진행
 * 1. 전체 라운드 수 만큼 자동차 이동
 * 1. 라운드 결과 저장
 * 1. 우승자 찾기
 */
public class Racing {

    private static final String INPUT_ERROR_MESSAGE = "1이상의 값을 입력해야 합니다.";
    private static final int RACING_MINIMUM_ROUND_COUNT = 1;

    private RacingCars racingCars;
    private int gameCount;
    private RacingRoundResults racingRoundResults;

    public Racing(List<String> carNames, int gameCount) {
        validateGameCount(gameCount);
        this.gameCount = gameCount;
        this.racingCars = RacingCars.newRacingCarsFrom(carNames);
        this.racingRoundResults = new RacingRoundResults();
    }

    private void validateGameCount(int gameCount) {
        if (!NumberUtil.isGreaterThan(gameCount, RACING_MINIMUM_ROUND_COUNT)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private void playOneRound() {
        this.racingCars = this.racingCars.moveCarAll();
        saveRoundResult();
    }

    private void saveRoundResult() {
        this.racingRoundResults = this.racingRoundResults.addResult(this.racingCars);
    }

    public void playAllRound() {
        for (int i = 0; i < this.gameCount; i++) {
            playOneRound();
        }
    }

    public List<String> findWinner() {
        return racingCars.findWinner();
    }

    public RacingRoundResults getRacingRoundResults() {
        return this.racingRoundResults;
    }
}
