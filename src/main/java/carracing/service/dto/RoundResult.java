package carracing.service.dto;

/**
 * RoundResult
 * description 경기 한 라운드 결과
 * version 0.0.3
 *
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) validator 멤버 삭제
 *  0.0.3) 비즈니스로직 제거, 단순 DTO 형태로 리팩토링
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
        this.roundNumber = roundNumber;
        this.racingScores = racingScores;
    }
}
