package carracing.controller.dto;

import carracing.service.dto.RoundResult;

import java.util.List;

public class CarRacingResponse {

    private final List<RoundResult> roundResultList;
    private final List<String> winnerNameList;

    public CarRacingResponse(List<RoundResult> roundResultList, List<String> winnerNameList) {
        this.roundResultList = roundResultList;
        this.winnerNameList = winnerNameList;
    }

    public List<RoundResult> getRoundResultList() {
        return roundResultList;
    }

    public List<String> getWinnerNameList() {
        return winnerNameList;
    }
}
