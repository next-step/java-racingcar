package racingcar.race;

import racingcar.util.CommonUtil;

public class RacingScorecard {
    private final String name;
    private final int position;

    public RacingScorecard(String name, int position) {
        CommonUtil.checkNullEmpty(name);
        CommonUtil.checkZeroOrMore(position);

        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
