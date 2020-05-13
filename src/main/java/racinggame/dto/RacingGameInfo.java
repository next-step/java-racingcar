package racinggame.dto;

public class RacingGameInfo {
    private final int numberOfCar;
    private final int numberOfAttempt;

    public RacingGameInfo(String numberOfCar, String numberOfAttempt) {
        try {
            this.numberOfCar = Integer.parseInt(numberOfCar);
            this.numberOfAttempt = Integer.parseInt(numberOfAttempt);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("자동차 대수와 시도횟수는 숫자로 입력해야합니다");
        }
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }
}
