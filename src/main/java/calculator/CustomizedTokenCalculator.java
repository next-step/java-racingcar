package calculator;

public class CustomizedTokenCalculator extends Calculator {

    @Override
    protected String[] operands(String str) {
        String[] splitResult = str.split(Constants.CUSTOMIZED_SEPARATOR_SUFFIX);

        String customizedToken = splitResult[0]
            .substring(splitResult[0].lastIndexOf(Constants.CUSTOMIZED_SEPARATOR_PREFIX) + 1);

        return splitResult[1].split("[" + customizedToken + "]");
    }
}
