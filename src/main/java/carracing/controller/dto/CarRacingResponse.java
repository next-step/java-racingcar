package carracing.controller.dto;

import java.util.List;

/**
 * CarRacingResponse
 * description 자동차 경주 API 응답정보
 * version 0.0.2
 *
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) 우승자 정보 추가
 */
public class CarRacingResponse {

    private final List<RoundResultInfo> roundResultInfoList;
    private final List<String> winnerList;

    public CarRacingResponse(List<RoundResultInfo> roundResultInfoList, List<String> winnerList) {
        this.roundResultInfoList = roundResultInfoList;
        this.winnerList = winnerList;
    }

    public List<RoundResultInfo> getRoundResultList() {
        return roundResultInfoList;
    }

    public List<String> getWinnerList() {
        return winnerList;
    }
}
