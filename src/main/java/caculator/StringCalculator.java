package caculator;

public class StringCalculator {

    public static int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        String[] result = value.split(",");
        
        int sum = 0;

        for (String s : result) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}
