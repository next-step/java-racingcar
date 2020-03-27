package study;

public class StringCalc {

    public static void main(String[] args) {

        String formula = "2 + 3 * 4 / 2";

        StringCalc calc = new StringCalc();

        if (calc.isBlank(formula)) {
            return;
        }

        String[] arr = formula.split(" ");

        int before = Integer.parseInt(arr[0]);
        int after = 0;
        String oper = "";
        for (int i = 1; i < arr.length; i++) {
            if ((i % 2) == 0) {
                after = Integer.parseInt(arr[i]);
                switch (oper) {
                    case "+":
                        before = calc.plus(before, after);
                        break;
                    case "-":
                        before = calc.minus(before, after);
                        break;
                    case "*":
                        before = calc.multiplication(before, after);
                        break;
                    case "/":
                        before = calc.division(before, after);
                        break;
                    default:
                        break;
                }
            } else if ((i % 2) == 1) {
                oper = arr[i];
            }
        }

        System.out.println("result: " + before);

    }

    public boolean isBlank(String val1) {
        if (!val1.trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int plus(int val1, int val2) {
        return val1 + val2;
    }

    public int minus(int val1, int val2) {
        return val1 - val2;
    }

    public int multiplication(int val1, int val2) {
        return val1 * val2;
    }

    public int division(int val1, int val2) {
        return val1 / val2;
    }

    public boolean isOperator(String val) {
        if (val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
}