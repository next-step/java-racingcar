import utils.validator.Validator;

public class StringAddCalculator {
    public static int splitAndSum(String text) {

        if (!Validator.validateUserInput(text)) {
            return 0;
        }

        return 1;
    }
}
