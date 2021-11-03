package step2.model;

public class Operator {

    public static Integer operator(String str) {
        String[] value = str.split(" ");
        return calculator(Integer.parseInt(value[0]), Integer.parseInt(value[2]), value[1]);
    }

    public static Integer calculator(int num1, int num2, String o) {
        if (o.equals("+")) {
            return num1 + num2;
        }
        if (o.equals("-")) {
            return num1 - num2;
        }
        if (o.equals("*")) {
            return num1 * num2;
        }
        if (o.equals("/")) {
            return num1 / num2;
        }
        throw new IllegalArgumentException();
    }


}
