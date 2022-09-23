package calculator;

public class C {
    public static int calculator(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        return Integer.parseInt(s);
    }
}
