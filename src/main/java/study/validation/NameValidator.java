package study.validation;

public class NameValidator implements RaceInputValidator{
    @Override
    public boolean validate(String value) {
        if(value.isBlank()) {
            return false;
        }
        return racingInputValidationForNames(value);
    }

    private static boolean racingInputValidationForNames(String value) {

        String[] splitNames = value.trim().split(",");
        int emptyCount = 0;

        for(String name : splitNames) {
            emptyCount += nameEmptyValidation(name);
        }

        if(emptyCount > 1) {
            return false;
        }

        return true;
    }

    private static int nameEmptyValidation(String word) {
        return word.isBlank() ? 1 : 0;
    }

}
