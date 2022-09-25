package stringcalculator;

import java.util.Objects;

public class Input {
    private static final String DEFAULT_DELIMITERS = ",|:";

    private String originalInput;
    private String delimiterRemovedInput;
    private String customDelimiter;

    public Input(String originalInput, String delimiterRemovedInput, String customDelimiter) {
        this.originalInput = originalInput;
        this.delimiterRemovedInput = delimiterRemovedInput;
        this.customDelimiter = customDelimiter;
    }

    public static Input hasNoDelimiter(String input) {
        return new Input(input, input, "");
    }

    public boolean useCustomDelimiter() {
        return customDelimiter != null && !customDelimiter.isBlank();
    }

    public String getDelimiter() {
        return useCustomDelimiter() ? customDelimiter : DEFAULT_DELIMITERS;
    }

    public String getInput() {
        return useCustomDelimiter() ? delimiterRemovedInput : originalInput;
    }

    public String[] split() {
        return getInput().split(getDelimiter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Input)) {
            return false;
        }
        Input input = (Input) o;
        return originalInput.equals(input.originalInput) && Objects.equals(delimiterRemovedInput,
                input.delimiterRemovedInput) && Objects.equals(customDelimiter, input.customDelimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalInput, delimiterRemovedInput, customDelimiter);
    }
}