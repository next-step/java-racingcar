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

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void setRacingScores(RacingScores racingScores) {
        this.racingScores = racingScores;
    }
}
