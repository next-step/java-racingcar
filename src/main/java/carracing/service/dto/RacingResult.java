package carracing.service.dto;

import carracing.domain.Winners;

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
    private final Winners winners;

    public RacingResult(List<RoundResult> roundResultList, Winners winners) {
        this.roundResultList = roundResultList;
        this.winners = winners;
    }

    public List<RoundResult> getRoundResultList() {
        return roundResultList;
    }

    public Winners getWinners() {
        return winners;
    }
}
