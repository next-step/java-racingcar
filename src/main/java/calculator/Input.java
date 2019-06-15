package calculator;

import java.util.Optional;

public class Input {

    private String value;

    private Input(String value) {
        this.value = value;
    }

    public static Input of(String value) {
        validate(value);
        return new Input(value);
    }

    private static void validate(String value) {
        Optional.ofNullable(value).orElseThrow(IllegalArgumentException::new);
    }


    public String[] splitByString() {
        return this.value.replace(" ","").split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    }

}
