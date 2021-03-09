package carracing.service.dto;

/**
 * RacingRegisterInfo
 * description 경기등록정보
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class RacingRegisterInfo {

    private int racingCarCount = 0;
    private int roundCount = 0;

    public int getRacingCarCount() {
        return racingCarCount;
    }

    public void setRacingCarCount(int racingCarCount) {
        this.racingCarCount = racingCarCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }
}
