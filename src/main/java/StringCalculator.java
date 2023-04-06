public class StringCalculator {

    public static int splitAndSum(String str) {
        Text text = new Text(str);
        if (text.isBlank()) {
            return 0;
        }
        String[] splitStrings = text.splitByPolicy();
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
