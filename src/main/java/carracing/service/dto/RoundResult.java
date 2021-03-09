package carracing.service.dto;

import java.util.List;

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
    private List<RacingScore> racingScoreList;

    public int getRoundNumber() {
        return roundNumber;
    }

    public List<RacingScore> getRacingScoreList() {
        return racingScoreList;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void setRacingScoreList(List<RacingScore> racingScoreList) {
        this.racingScoreList = racingScoreList;
    }
}
