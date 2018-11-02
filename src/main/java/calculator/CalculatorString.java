package calculator;

/**
 * 1 + 2 * 3 / 5
 */
public class CalculatorString {
    public static int calculate(String text) {
        String[] values = text.split(" ");


        for (int i=0; i<values.length; i++) {
            String data = values[i];
            String middle = null;
            if(!isNumber(data)) {
                middle = data;
            }

            int result = calcu(middle, i, i+2);

        }



        return 0;
    }

    public static int calcu(String middle, int first, int second) {
        if (middle.equals("+")) {
            return first + second;
        }

        if (middle.equals("-")) {
            return first - second;
        }

        if (middle.equals("*")) {
            return first * second;
        }

        if (middle.equals("/")) {
            return first / second;
        }

        return 0;
    }




    public static boolean isNumber(String data) {
        try{
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public static int add(int i, int j) {
        return i + j;
    }

    public static int min(int i, int j) {
        return i - j;
    }

    public static int mul(int i, int j) {
        return i * j;
    }

    public static int div(int i, int j) {
        return i / j;
    }
}
