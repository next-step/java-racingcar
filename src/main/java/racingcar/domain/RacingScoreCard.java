package racingcar.domain;

import racingcar.util.CommonUtil;

public class RacingScoreCard {
    private final String name;
    private final int position;

    public RacingScoreCard(String name, int position) {
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
