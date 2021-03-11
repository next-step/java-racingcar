package study.step4;

import java.util.Arrays;

public class StringValidation {

    private StringValidation() {
    }

    public static void validateCarNameSize(String[] carNames) {
        Arrays.stream(carNames)
                .forEach(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException(RacingGameError.CAR_NAME_LENGTH_OVER);
                    }
                });
    }
}
