package racingcar.domain;

public class InputData {
    private final Integer carNumber;
    private final Integer gameRound;

    public InputData(Integer carNumber, Integer gameRound) {
        validateNegativeNumber(carNumber, gameRound);
        this.carNumber = carNumber;
        this.gameRound = gameRound;
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public Integer getGameRound() {
        return gameRound;
    }

    private static void validateNegativeNumber(Integer carNumber, Integer gameRound) {
        if (carNumber <= 0) throw new IllegalArgumentException("자동차 대수는 양수만 입력가능합니다");
        if (gameRound <= 0) throw new IllegalArgumentException("자동차 시도 횟수는 양수만 입력 가능합니다");
    }


}
