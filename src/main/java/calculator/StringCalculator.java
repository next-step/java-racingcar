package calculator;

public class StringCalculator {

    static int calculate(String text) {
        String[] values = text.split(" ");
        int i = Integer.parseInt(values[0]);
        String mix = values[1];
        int j = Integer.parseInt(values[2]);
        return setFormatMix(i, mix, j);
    }

    static int setFormatMix(int i, String s, int j) {
        switch (s) {
            case "+":
                return add(i, j);
            case "-":
                return sub(i, j);
            case "/":
                return div(i, j);
            case "*":
                return multi(i, j);
        }
        return 0;
    }

    static int add(int i, int j) {
        return i + j;
    }

    public static int sub(int i, int j) {
        return i - j;
    }

    public static int multi(int i, int i1) {
        return i * i1;
    }

    public static int div(int i, int i1) {
        return i / i1;
    }
}
