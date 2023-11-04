package calculator;

public class Calculator {

    public static final String DELIMITER = ",|:";

    public static int cal(String text) {

        if (isBlank(text)) {
            return 0;
        }

        return sum(toInts(split(text)));
    }

    private static String[] split(String text) {
        return text.split(DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for(int number : numbers){
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values){
        int[] numbers = new int[values.length];
        for(int i=0; i<values.length; i++){
            numbers[i] = Integer.parseInt(values[i]);
        }

        return numbers;
    }
}
