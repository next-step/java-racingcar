package carracing.service.dto;

/**
 * RoundResult
 * description 경기 한 라운드 결과
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class RoundResult {

    private int roundNumber;
    private RacingScores racingScores;

    public int getRoundNumber() {
        return roundNumber;
    }

    public RacingScores getRacingScores() {
        return racingScores;
    }

    public void registerRoundResult(int roundNumber, RacingScores racingScores) {
        _validate(roundNumber);
        this.roundNumber = roundNumber;
        this.racingScores = racingScores;
    }

    private void _validate(int roundNumber) {
        if(this.roundNumber== roundNumber) {
            throw new IllegalArgumentException("해당 경기 정보는 이미 등록되었습니다.");
        }
    }
}
