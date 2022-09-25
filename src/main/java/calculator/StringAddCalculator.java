package calculator;

public class StringAddCalculator {

    public static final String SEPARATOR = ",|;";

    public static int splitAndSum(String s) {
        if (isBlank(s)){
            return 0;
        }
        return sum(toInts(split(s)));
    }

    private static String[] split(String s) {
        String[] values = s.split(SEPARATOR);
        return values;
    }

    private static boolean isBlank(String s) {
        return s == null || s == "";
    }

    private static int sum(int[] values) {
        int result = 0;
        for(int value : values){
            result += value;
        }
        return result;
    }

    private static Positive sum(Positive[] values) {
        Positive result = new Positive(0);
        for(Positive value : values){
            result = result.plus(value);
        }
        return result;
    }

    private static int[] toInts(String[] values){
        int[] numbers = new int[values.length];
        for(int i = 0; i < values.length; i++){
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private static int toPositive(String value) {
        int numbers = Integer.parseInt(value);
        if(numbers < 0) throw new RuntimeException();
        return numbers;
    }
}
