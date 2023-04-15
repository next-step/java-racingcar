package step3.dto;

public class RacingCarInputDto {
    private final String carNames;
    private final int tryNumbers;

    public RacingCarInputDto(String carNames, int tryNumbers) {
        this.carNames = carNames;
        this.tryNumbers = tryNumbers;
    }

    public String getCarNames(){
        return carNames;
    }
    public int getTryNumbers() {
        return tryNumbers;
    }
}
