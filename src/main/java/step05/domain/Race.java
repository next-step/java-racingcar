package step05.domain;

import validator.NumberValidator;

public class Race {
    private final int numberOfMoves;

    private Race(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
        validateNumberOfMoves();
    }

    public static Race of(int numberOfMoves) {
        return new Race(numberOfMoves);
    }

    private void validateNumberOfMoves() {
        NumberValidator.validatePositiveInteger(numberOfMoves);
    }
}
