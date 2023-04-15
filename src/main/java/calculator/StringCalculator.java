package calculator;

public class StringCalculator {
    public static final int ZERO = 0;
    public static final String DELIMITER = ",|:";

    public static int splitAndSum(String text){
        if(isBlank(text))
            return ZERO;

        return sum(isInts(split(text)));
    }

    private static String[] split(String text){
        return text.split(DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers) {
        int sum = ZERO;
        
        for(int number : numbers)
            sum += number;
        
        return sum;
    }

    private static int[] isInts(String[] values) {
        int[] numbers = new int[values.length];

        for(int i = 0; i < values.length; i++) {
            int number = toInt(values[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    private static int toInt(String values) {
        int number = Integer.parseInt(values);
        if(number < ZERO)
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        return number;
    }
}
