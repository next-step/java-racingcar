package racinggame.dto;

public class RacingGameInfo {
    private final int numberOfCar;
    private final int numberOfAttempt;

    public RacingGameInfo(String numberOfCar, String numberOfAttempt) {
        try {
            int inputNumberOfCar = Integer.parseInt(numberOfCar);
            int inputNumberOfAttempt = Integer.parseInt(numberOfAttempt);

            validate(inputNumberOfCar, inputNumberOfAttempt);

            this.numberOfCar = inputNumberOfCar;
            this.numberOfAttempt = inputNumberOfAttempt;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("자동차 대수와 시도횟수는 숫자로 입력해야합니다");
        }
    }

    private void validate(int inputNumberOfCar, int inputNumberOfAttempt) {
        if (inputNumberOfAttempt <= 0 || inputNumberOfCar <= 0) {
            throw new IllegalArgumentException("0이하의 수는 입력할 수 없습니다");
        }
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }
}
