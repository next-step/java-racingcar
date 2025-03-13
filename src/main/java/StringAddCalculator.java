public class StringAddCalculator {
    public static Integer splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] split = text.split(",");
        int sum = 0;
        for (String s : split) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}
