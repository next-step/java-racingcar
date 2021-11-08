package step2;

public class Calculator {

    public static Operand calculate(String s) {
        if (s == null || s.trim().length() == 0) {
            throw new IllegalArgumentException();
        }

        String[] split = s.split(" ");
        Operand ans = new Operand(split[0]);
        for (int i = 1; i < split.length; i += 2) {
            ans = Operator.getOperator(split[i]).calculate(ans, new Operand(split[i + 1]));
        }
        return ans;
    }
}
