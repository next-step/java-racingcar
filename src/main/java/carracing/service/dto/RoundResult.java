package carracing.service.dto;

import java.util.List;

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
    private final List<RacingScore> racingScoreList;

    public int getRoundNumber() {
        return roundNumber;
    }

    public List<RacingScore> getRacingScoreList() {
        return racingScoreList;
    }

    public RoundResult(int roundNumber, List<RacingScore> racingScoreList) {
        this.roundNumber = roundNumber;
        this.racingScoreList = racingScoreList;
    }
}
