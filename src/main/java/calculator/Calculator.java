package calculator;

public class Calculator {

    public static final String BASIC_DELIMITER = ",|:";
    public static final String CUSTOM_START_TEXT = "//";
    public static final String CUSTOM_SPLIT_TEXT = "//|\n";

    public static int cal(String text) {

        if (isBlank(text)) {
            return 0;
        }

        String delimiter = extractDelimiter(text);
        text = extractText(text);

        return sum(toInts(split(text, delimiter)));
    }

    private static String extractDelimiter(String text){

        if (text.startsWith(CUSTOM_START_TEXT)) {
            String[] result = split(text, CUSTOM_SPLIT_TEXT);
            return result[1];
        }

        return BASIC_DELIMITER;
    }

    private static String extractText(String text){
        if (text.startsWith(CUSTOM_START_TEXT)){
            String[] result = split(text, CUSTOM_SPLIT_TEXT);
            return result[2];
        }

        return text;
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(PositiveNumber numbers) {
        int sum = 0;

        for(int number : numbers.positiveNums){
            sum += number;
        }
        return sum;
    }

    private static PositiveNumber toInts(String[] values){

        PositiveNumber positiveNumbers = new PositiveNumber(values);

        return positiveNumbers;
    }

}
