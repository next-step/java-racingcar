package step3.dto;

public class RacingCarInputDto {
    private final int carNumbers;
    private final int tryNumbers;

    public RacingCarInputDto(int carNumbers, int tryNumbers) {
        this.carNumbers = carNumbers;
        this.tryNumbers = tryNumbers;
    }

    public int getCarNumbers() {
        return carNumbers;
    }

    public int getTryNumbers() {
        return tryNumbers;
    }
}
