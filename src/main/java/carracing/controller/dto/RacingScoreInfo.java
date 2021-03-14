package carracing.controller.dto;

/**
 * RacingScoreInfo
 * description 레이싱 점수정보
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class RacingScoreInfo {

    private final int score;

    public RacingScoreInfo(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
