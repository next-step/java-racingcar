package racingcar.controller.dto;


public class CarRequestDto {

    private String names;
    private String numberOfAttempts;

    public CarRequestDto(String names, String numberOfAttempts) {
        this.names = names;
        this.numberOfAttempts = numberOfAttempts;
    }

    public String getNames() {
        return names;
    }

    public String getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
