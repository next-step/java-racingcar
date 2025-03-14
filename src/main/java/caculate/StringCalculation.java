package caculate;

public class StringCalculation {
    public static int add(String input) {
        String[] values = input.split(",");
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }
}
