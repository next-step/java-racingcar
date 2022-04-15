package carrace;

public enum CarRaceRule {
    DECISION_VALUE(4), GO(1), STOP(0);

    private final int value;

    CarRaceRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
