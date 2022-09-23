package calculator;

public class C {
    public static int calculator(String text) {
        if (text == null || text.equals("")) {
            return 0;
        }
        String[] arr = text.split(",");
        int result = 0;
        for (String str : arr) {
            result += Integer.parseInt(str);
        }
        return result;
    }
}
