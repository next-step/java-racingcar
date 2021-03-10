package carracing.controller.dto;

import java.util.List;

/**
 * CarRacingResponse
 * description 자동차 경주 API 응답정보
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class CarRacingResponse {

    private List<RoundResultInfo> roundResultInfoList;

    public List<RoundResultInfo> getRoundResultList() {
        return roundResultInfoList;
    }

    public void setRoundResultList(List<RoundResultInfo> roundResultInfoList) {
        this.roundResultInfoList = roundResultInfoList;
    }
}
