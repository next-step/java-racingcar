package carracing.service.dto;

import carracing.constants.CarRacingConstant;

/**
 * RoundResult
 * description 경기 한 라운드 결과
 * version 0.0.2
 *
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) validator 멤버 삭제
 */
public class RoundResult {

    private final int roundNumber;
    private final RacingScores racingScores;

    public int getRoundNumber() {
        return roundNumber;
    }

    public RacingScores getRacingScores() {
        return racingScores;
    }

    public RoundResult(int roundNumber, RacingScores racingScores) {
        validateRoundNumber(roundNumber);
        validateRacingScores(racingScores);
        this.roundNumber = roundNumber;
        this.racingScores = racingScores;
    }

    private void validateRoundNumber(int roundNumber) {
        if(roundNumber < CarRacingConstant.MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("라운드 회차는 최소 1 이상이어야 합니다.");
        }
    }

    private void validateRacingScores(RacingScores racingScores) {
        if(racingScores==null) {
            throw new IllegalArgumentException("경기 정보가 존재하지 않습니다.");
        }
    }
}
