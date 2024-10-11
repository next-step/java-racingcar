package study.validation;

import study.racing.constants.RacingMessage;

public class CountValidator implements RaceInputValidator{

    @Override
    public boolean validate(String value) {
        if(value.isBlank()) {
            return false;
        }
        return validateCounts(value);
    }

    private static boolean validateCounts(String value) {
        if(Integer.parseInt(value) < 0 ) {
            System.out.println(RacingMessage.TRY_AGAIN.msg());
            throw new NumberFormatException();
        }
        return true;
    }

}
