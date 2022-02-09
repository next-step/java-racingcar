package racinggame.domain.dto;

public class TrialDto {

    private final int value;

    public TrialDto(final String value) {
        this.value = parse(value);
    }

    public int getValue() {
        return this.value;
    }

    private int parse(final String inputTrial) {
        return Integer.parseInt(inputTrial);
    }
}
