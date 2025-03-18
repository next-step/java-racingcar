package domain;

public class RacingGame {

    private Integer numberOfCar;
    private Integer numberOfTrial;

    public RacingGame(Integer numberOfCar, Integer numberOfTrial) {
        if (isValid(numberOfCar, numberOfTrial)) {
            throw new IllegalArgumentException("자동차의 수 또는 시도 횟수는 0보다 커야 합니다.");
        }

        this.numberOfCar = numberOfCar;
        this.numberOfTrial = numberOfTrial;
    }

    private static boolean isValid(Integer numberOfCar, Integer numberOfTrial) {
        return numberOfCar <= 0 || numberOfTrial <= 0;
    }

    public RacingGameResult gameStart() {
        return new RacingGameResult();
    }
}
