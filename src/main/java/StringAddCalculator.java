public class StringAddCalculator {

    static int splitAndSum(String str) {
        String delimiter = ",";
        int sum = 0;

        if (str == null || str.isBlank()) return sum;

        String[] splitString = str.split(delimiter);

        for (String value : splitString) {
            sum += Integer.parseInt(value);
        }

        return sum;
    }
}
