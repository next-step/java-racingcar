package racingcar_step3;

public enum CarRacingEnum {
    RANDOM_RANGE (10),
    MOVE_POSSIBLE_VALUE(4),
    STOP_VALUE(0),
    FORWARD_VALUE(1)
    ;

    private int value;

    CarRacingEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
