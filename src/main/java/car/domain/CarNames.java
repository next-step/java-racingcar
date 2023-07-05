package car.domain;

public final class CarNames {
    private String[] carNames;
    private final String CAR_NAMES_DELIMITER = ",";
    private final int ZERO = 0;

    public CarNames(String names) {
        String[] carNames = validateCarNames(names);
        this.carNames = carNames;
    }

    private String[] validateCarNames(String names) {
        if (names == null || names.isBlank()) {
            throw new RuntimeException();
        }

        String[] tokenCarNames = tokenCarNames(names);
        if (tokenCarNames.length == ZERO) {
            throw new RuntimeException();
        }

        return tokenCarNames;
    }

    private String[] tokenCarNames(String carNames) {
        return carNames.split(CAR_NAMES_DELIMITER);
    }

    public String[] getCarNames() {
        return carNames;
    }
}
