package racingcar.controller.dto;


public class CarRequestDto {

    private String numberOfCars;
    private String numberOfAttempts;

    public CarRequestDto(String numberOfCars, String numberOfAttempts) {
        this.numberOfCars = numberOfCars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public String getNumberOfCars() {
        return numberOfCars;
    }

    public String getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
