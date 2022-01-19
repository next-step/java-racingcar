package racinggame.domain;

public class Validator {

    public static void validatePossibleToStart(String[] carNames) {
        if (carNames.length < 2) {
            throw new IllegalArgumentException("참가자는 2명 이상입니다.");
        }
    }
}
