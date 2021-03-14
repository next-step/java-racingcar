package carracing.controller.dto;

/**
 * CarRacingRequest
 * description 자동차 경주 API 요청정보
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class CarRacingRequest {

    private final int racingCarCount;
    private final int roundCount;

    public CarRacingRequest(int racingCarCount, int roundCount) {
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
