package carracing.service.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * RacingResult
 * description 레이싱 경기결과
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class RacingResult {

    List<RoundResult> roundResultList = new ArrayList<>();

    public List<RoundResult> getRoundResultList() {
        return roundResultList;
    }

    public void registerRoundResult(RoundResult roundResult) {
        this.roundResultList.add(roundResult);
    }
}
