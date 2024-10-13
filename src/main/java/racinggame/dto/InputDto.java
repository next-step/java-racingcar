package racinggame.dto;

public class InputDto {

    private final String carNames;
    private final int repeatCount;

    public InputDto(String carNames, int repeatCount) {
        this.carNames = carNames;
        this.repeatCount = repeatCount;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getRepeatCount() {
        return repeatCount;
    }
}
