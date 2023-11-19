package step5.model.enums;

public enum StandardNumber {
    NAME_LENGTH_LIMIT_STANDARD(5)
    , CAR_MOBILITY_STANDARD(5)
    ;

    private final int standard;

    StandardNumber(int standard) {
        this.standard = standard;
    }

    public int number() {
        return standard;
    }
}
