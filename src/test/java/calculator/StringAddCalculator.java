package calculator;

public class StringAddCalculator {

    String text;
    private static String division = ",:";



    static int splitAndSum(String text) {
        if (isEmpty(text))
            return 0;
        CustomDivisionCheck(text);

        return 0;
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static void CustomDivisionCheck(String text) {
        if (text.contains("//") && text.contains("\n")) {
            int start = text.indexOf("//");
            int end = text.indexOf("\n");
            division = text.substring(start + 1, end);
        }
    }
}
