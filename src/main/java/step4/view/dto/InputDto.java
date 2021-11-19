package step4.view.dto;

public class InputDto {
    private String[] inputCarNames;
    private int numberOfAttempts;

    private InputDto(){}

    public static InputDto of(String[] inputCarNames, int numberOfAttempts) {
        InputDto inputDto = new InputDto();
        inputDto.inputCarNames = inputCarNames;
        inputDto.numberOfAttempts = numberOfAttempts;
        return inputDto;
    }

    public String[] getInputCarnames() {
        return inputCarNames;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

}