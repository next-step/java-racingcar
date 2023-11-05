package calculator;

public class Calculator {

    public static final String DELIMITER = ",|:";

    public static int cal(String text) {
        String customDelimiter = "";

        if (isBlank(text)) {
            return 0;
        }
        if (text.startsWith("//")){
            String[] result = split(text, "//|\n");
            customDelimiter = result[1];
            text = result[2];

            return sum(toInts(split(text, customDelimiter)));
        }

        return sum(toInts(split(text, DELIMITER)));
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
