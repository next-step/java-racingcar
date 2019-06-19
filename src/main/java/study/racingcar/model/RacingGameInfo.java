package study.racingcar.model;

import java.util.Set;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RacingGameInfo {
    private Set<String> carNames;
    private int moveCarTryLimit;

    public RacingGameInfo(Set<String> carNames, int moveCarTryLimit) {
        this.carNames = carNames;
        this.moveCarTryLimit = moveCarTryLimit;
    }

    public Set<String> getCarNames() {
        return carNames;
    }

    public int getMoveCarTryLimit() {
        return moveCarTryLimit;
    }
}
