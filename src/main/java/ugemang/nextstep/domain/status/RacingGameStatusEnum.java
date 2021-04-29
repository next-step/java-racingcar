package ugemang.nextstep.domain.status;

public enum RacingGameStatusEnum {
    DRIVE(4),
    MAX_SPEED(10);

    int val;

    RacingGameStatusEnum(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
