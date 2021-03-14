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

    private final int roundNumber;
    private final List<RacingScoreInfo> racingScoreInfoList;

    public RoundResultInfo(int roundNumber, List<RacingScoreInfo> racingScoreInfoList) {
        this.roundNumber = roundNumber;
        this.racingScoreInfoList = racingScoreInfoList;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public List<RacingScoreInfo> getRacingScoreInfoList() {
        return racingScoreInfoList;
    }
}
