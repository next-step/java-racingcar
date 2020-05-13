package racingcar.dto;

public class InputValueDto {
    private int numberOfCar;
    private int numberOfPhase;

    public InputValueDto(String numberOfCar, String numberOfPhase) {
        try {
            this.numberOfCar = Integer.parseInt(numberOfCar);
            this.numberOfPhase = Integer.parseInt(numberOfPhase);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("자동차 대수와 시도 회수는 숫자여야 합니다.");
        }
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getNumberOfPhase() {
        return numberOfPhase;
    }
}
