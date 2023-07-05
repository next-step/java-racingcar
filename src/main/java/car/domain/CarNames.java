package car.domain;

public class CarNames {
    private String[] carNames;
    public CarNames(String names) {
        String [] carNames = validateCarNames(names);
        this.carNames = carNames;
    }

    private String[] validateCarNames (String names) {
        if (names == null || names.isBlank()) throw new RuntimeException();
        String [] tokenCarNames = tokenCarNames(names);
        if (tokenCarNames.length == 0) throw new RuntimeException();
        return tokenCarNames;
    }
    private String[] tokenCarNames(String carNames) {
         return carNames.split(",");
    }

    public String[] getCarNames () {
        return carNames;
    }
}
