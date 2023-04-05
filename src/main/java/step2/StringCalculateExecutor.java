package step2;

import step2.model.Input;

public class StringCalculateExecutor {

    private final StringCalculateSeparator stringCalculateSeparator;
    private final StringCalculateValidateExecutor stringCalculateValidateExecutor;
    private final StringCalculateCalculator stringCalculateCalculator;

    public StringCalculateExecutor(
            StringCalculateSeparator stringCalculateSeparator,
            StringCalculateValidateExecutor stringCalculateValidateExecutor,
            StringCalculateCalculator stringCalculateCalculator
    ) {
        this.stringCalculateSeparator = stringCalculateSeparator;
        this.stringCalculateValidateExecutor = stringCalculateValidateExecutor;
        this.stringCalculateCalculator = stringCalculateCalculator;
    }

    public int execute(String inputString) {

        Input input = stringCalculateSeparator.executeSeparator(inputString);

        stringCalculateValidateExecutor.executeValidator(input);

        return stringCalculateCalculator.executeCalculator(input);
    }


}
