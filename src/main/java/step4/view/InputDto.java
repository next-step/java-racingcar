package step4.view;


public class InputDto {

    private final String carNames;
    private final int carRacingChance;

    public InputDto(String carNames, int carRacingChance) {
        this.carNames = carNames;
        this.carRacingChance = carRacingChance;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getCarRacingChance() {
        return carRacingChance;
    }
}
