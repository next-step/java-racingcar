package calculator;

public class CustomizedTokenCalculator extends Calculator {

    @Override
    protected String[] operands(String str) {
        String[] splitResult = str.split("\n");

        String customizedToken = splitResult[0]
            .substring(splitResult[0].lastIndexOf("/") + 1);

        return splitResult[1].split("[" + customizedToken + "]");
    }
}
