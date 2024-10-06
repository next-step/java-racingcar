package racinggame.dto;

public class InputDto {

    private final int carCount;
    private final int repeatCount;

    public InputDto(int carCount, int repeatCount) {
        this.carCount = carCount;
        this.repeatCount = repeatCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRepeatCount() {
        return repeatCount;
    }
}
