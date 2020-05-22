package study.step4;

import java.util.List;
import java.util.Objects;

public class Champion {
    private final static String ROUNDS_ILLEGAL_EXCEPTION = "최소 실행 라운드는 1회 이상입니다.";

    private final Round round;

    public Champion(Round round) {
        validateRound(round);
        this.round = round;
    }

    private void validateRound(Round round) {
        if (Objects.isNull(round)){
            throw new IllegalArgumentException(ROUNDS_ILLEGAL_EXCEPTION);
        }
    }

    public List<String> getChampions() {
        return round.decideChampion();
    }
}
