package caculate;

public class StringCalculation {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] values = input.split("[,:]");
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }
}
