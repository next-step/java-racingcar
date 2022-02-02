package racinggame.domain.vo;

public class InputVo {

    private final String carNames;
    private final String trial;

    public InputVo(final String carNames, final String trial) {
        this.carNames = carNames;
        this.trial = trial;
    }

    public String getCarNames() {
        return this.carNames;
    }

    public String getTrial() {
        return this.trial;
    }
}
