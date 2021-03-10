package carracing.controller.dto;

import java.util.List;

/**
 * RoundResultInfo
 * description 라운드 결과정보
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class RoundResultInfo {

    private int roundNumber;
    private List<RacingScoreInfo> racingScoreInfoList;

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public List<RacingScoreInfo> getRacingScoreInfoList() {
        return racingScoreInfoList;
    }

    public void setRacingScoreInfoList(List<RacingScoreInfo> racingScoreInfoList) {
        this.racingScoreInfoList = racingScoreInfoList;
    }
}
