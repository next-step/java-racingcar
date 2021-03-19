package carracing.service.dto;

import carracing.domain.Car;

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
    private final List<Car> winnerList;

    public RacingResult(List<RoundResult> roundResultList, List<Car> winnerList) {
        this.roundResultList = roundResultList;
        this.winnerList = winnerList;
    }

    public List<RoundResult> getRoundResultList() {
        return roundResultList;
    }

    public List<Car> getWinnerList() {
        return winnerList;
    }
}
