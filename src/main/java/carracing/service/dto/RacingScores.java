package carracing.service.dto;

import java.util.List;

/**
 * RacingScores
 * description 경기 점수목록
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class RacingScores {

    private final List<RacingScore> racingScoreList;

    public List<RacingScore> getRacingScoreList() {
        return racingScoreList;
    }

    public RacingScores(List<RacingScore> racingScoreList) {
        this.racingScoreList = racingScoreList;
    }

}
