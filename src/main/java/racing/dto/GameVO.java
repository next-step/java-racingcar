package racing.dto;

import racing.utils.ValidationUtil;

public class GameVO {

    private final String carNames;
    private final int round;

    public GameVO(String names, int round) {
        ValidationUtil.validateInput(names, round);
        this.carNames = names;
        this.round = round;
    }

    public String[] getCarNames() {
        return carNames.split(",");
    }

    public int getRound() {
        return round;
    }
}
