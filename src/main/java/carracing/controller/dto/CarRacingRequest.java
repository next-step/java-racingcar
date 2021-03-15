package carracing.controller.dto;

/**
 * CarRacingRequest
 * description 자동차 경주 API 요청정보
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) racingCarCount 제거 및 racingCarNames 추가
 */
public class CarRacingRequest {

    private final String racingCarNames;
    private final int roundCount;

    public CarRacingRequest(String racingCarNames, int roundCount) {
        this.racingCarNames = racingCarNames;
        this.roundCount = roundCount;
    }

    public String getRacingCarNames() {
        return racingCarNames;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
