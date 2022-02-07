package racinggame.domain;

public class Trial {

    private final int value;

    public Trial(final String value) {
        this.value = parse(value);
    }

    public int getValue() {
        return this.value;
    }

    private int parse(final String inputTrial) {
        return Integer.parseInt(inputTrial);
    }
}
