package game.domain;

public enum CarAction {
    MOVE("-"),
    STOP("");

    private final String value;

    CarAction(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
