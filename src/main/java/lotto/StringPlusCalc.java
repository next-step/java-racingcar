package lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalc {
    private String[] userEnteredNumbers;

    public StringPlusCalc(String entered) {
        inputSplit(entered);
    }

    private void inputSplit(String entered) {
        if (enteredIsEmptyOrNull(entered)) {
            return;
        }
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(entered);
        if (matcher.find()) {
            userCustomDelimiter(matcher);
            return;
        }

        String[] text = entered.split(",|:");
        calcValidation(text);
    }

    private boolean enteredIsEmptyOrNull(String entered) {
        if (entered == null || entered.isEmpty()) {
            userEnteredNumbers = new String[] {"0"};
            return true;
        }
        return false;
    }

    private void userCustomDelimiter(Matcher matcher) {
        String delimiter = matcher.group(1);
        String[] text = matcher.group(2).split(delimiter);

        calcValidation(text);
    }

    private void calcValidation(String[] text) {
        for (String charStr : text) {
            textIsNumber(charStr);
            greaterThanZero(charStr);
            userEnteredNumbers = text;
        }
    }

    private void greaterThanZero(String charStr) {
        if (Integer.parseInt(charStr) < 0) {
            throw new RuntimeException("You can not enter a negative number");
        }
    }

    private boolean textIsNumber(String charStr) {
        boolean isNum = Pattern.matches("^[0-9]*$", charStr);
        if (!isNum) {
            throw new RuntimeException("You can only enter number");
        }
        return isNum;
    }

    public int sum() {
        int resultNum = 0;
        for (String numberStr : this.userEnteredNumbers) {
            resultNum += Integer.parseInt(numberStr);
        }
        return resultNum;
    }
}
