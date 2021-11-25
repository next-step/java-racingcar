package study.racingcar.dto;

public class RequestDto {
    private String carNames;
    private int tryCount;

    public RequestDto(String carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTryRound() {
        return tryCount;
    }
}
