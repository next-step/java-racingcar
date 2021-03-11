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

    private int racingCarCount;
    private int roundCount;

    public RacingRegisterInfo(int racingCarCount, int roundCount) {
        this.racingCarCount = racingCarCount;
        this.roundCount = roundCount;
    }

    public int getRacingCarCount() {
        return racingCarCount;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
