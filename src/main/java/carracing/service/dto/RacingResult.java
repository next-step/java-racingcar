package carracing.service.dto;

import java.util.List;

/**
 * RacingResult
 * description 레이싱 경기결과
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 *  0.0.2) 생성자 추가 (도메인로직을 포함한 빌드)
 */
public class RacingResult {

    private final List<RoundResult> roundResultList;

    public List<RoundResult> getRoundResultList() {
        return roundResultList;
    }

    public RacingResult(List<RoundResult> roundResultList) {
        this.roundResultList = roundResultList;
    }
}
