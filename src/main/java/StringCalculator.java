public class StringCalculator {

    public static int splitAndSum(String text) {
        CalculatorInputText calculatorInputText = new CalculatorInputText(text);
        if (calculatorInputText.isBlank()) {
            return 0;
        }
        String[] splitStrings = calculatorInputText.splitByPolicy();
        return toPositiveInts(splitStrings).sum();
    }

    private static PositiveInts toPositiveInts(String[] strings) {
        PositiveInt[] parsedNumbers = new PositiveInt[strings.length];
        for (int i = 0; i < strings.length; i++) {
            parsedNumbers[i] = new PositiveInt(strings[i]);
        }
        return new PositiveInts(parsedNumbers);
    }
}
