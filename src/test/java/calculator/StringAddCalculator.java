package calculator;

public class StringAddCalculator {
    private static String division = "[,:]";

    static int splitAndSum(String text) {
        if (isEmpty(text))
            return 0;
        text = CustomDivisionCheck(text);
        return StringDivision(text);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String CustomDivisionCheck(String text) {
        if (text.contains("//") && text.contains("\n")) {
            int start = text.indexOf("//");
            int end = text.indexOf("\n");
            division = text.substring(start + 2, end);
            return text.substring(end + 1);
        }
        return text;
    }

    private static int StringDivision(String text) {
        String[] texts = text.split(division);
        return StringToInt(texts);
    }

    private static int StringToInt(String[] texts) {
        int sum = 0;
        for (String text : texts) {
            int num = Integer.parseInt(text);
            NumberMinusCheck(num);
            sum += num;
        }
        return sum;
    }

    private static void NumberMinusCheck(int num) {
        if (num < 0)
            throw new RuntimeException("음수입니다");
    }
}
