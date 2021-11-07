package step2;

public class Calculator {

    public static int execute(InputString inputString) {
        int ans = Integer.parseInt(inputString.get(0));
        for (int i = 0; i < inputString.getLength() - 2; i += 2) {
            ans = Operator.from(inputString.get(i + 1)).operate(ans, Integer.parseInt(inputString.get(i + 2)));
        }
        return ans;
    }
}
