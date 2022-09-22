public class StringAddCalculator {

    static int splitAndSum(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
