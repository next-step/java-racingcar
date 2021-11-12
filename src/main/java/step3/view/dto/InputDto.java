package step3.view.dto;

public class InputDto {
    private int numberOfCars;
    private int numberOfAttempts;

    private InputDto(){}

    public static InputDto of(int numberOfCars, int numberOfAttempts) {
        InputDto inputDto = new InputDto();
        inputDto.numberOfCars = numberOfCars;
        inputDto.numberOfAttempts = numberOfAttempts;
        return inputDto;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

}