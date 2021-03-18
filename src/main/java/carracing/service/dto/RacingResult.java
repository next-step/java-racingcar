package carracing.service.dto;

import java.util.List;

/**
 * RacingResult
 * description 레이싱 경기결과
 * version 0.0.3
 *
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) 생성자 추가 (도메인로직을 포함한 빌드)
 *  0.0.3) 우승자 정보 추가
 */
public class RacingResult {

    private final List<RoundResult> roundResultList;
    private final List<String> winnerNameList;

    public RacingResult(List<RoundResult> roundResultList, List<String> winnerNameList) {
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
