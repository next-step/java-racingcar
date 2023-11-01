package stringaddcalculator.validator;

public class StringValidator {
    private StringValidator() {
    }

    public static boolean isNullOrEmptyString(final String inputString) {
        return inputString == null || inputString.isEmpty();
    }

    public static boolean isOneCharacterString(final String inpuString) {
        return inpuString.length() == 1;
    }
}
