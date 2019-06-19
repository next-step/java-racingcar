package study.racingcar.model;

import java.util.Set;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RacingGameInfo {
    private Set<String> driverNames;
    private int moveCarTryLimit;

    public RacingGameInfo(Set<String> driverNames, int moveCarTryLimit) {
        this.driverNames = driverNames;
        this.moveCarTryLimit = moveCarTryLimit;
    }

    public Set<String> getDriverNames() {
        return driverNames;
    }

    public int getMoveCarTryLimit() {
        return moveCarTryLimit;
    }
}
