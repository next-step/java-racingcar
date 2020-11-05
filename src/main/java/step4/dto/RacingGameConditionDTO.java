package step4.dto;

public class RacingGameConditionDTO {
    private String carNames;
    private int tryCount;


    private RacingGameConditionDTO(String carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public static RacingGameConditionDTO of(String carNames , int tryCount){
        return new RacingGameConditionDTO(carNames , tryCount);
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
