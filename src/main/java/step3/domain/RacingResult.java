package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 컬렉션 정보를 관리하는 레이싱 결과를 담는 클래스
 */
public class RacingResult {

    private final List<RacingRound> racingRounds;

    public RacingResult() {
        this.racingRounds = new ArrayList<>();
    }

    public void addRacingRound(RacingRound racingRound) {
        this.racingRounds.add(racingRound);
    }

    public List<RacingRound> getRacingRounds() {
        return Collections.unmodifiableList(racingRounds);
    }
}
