public class Calculator {

    public static int calc(String s) {
        String[] split = s.split(" ");
        int first = Integer.parseInt(split[0]);
        int second = Integer.parseInt(split[2]);
        String operator = split[1];

        int ans = 0;
        if (operator.equals("+")) {
            ans = first + second;
        } else if (operator.equals("-")) {
            ans = first - second;
        } else if (operator.equals("*")) {
            ans = first * second;
        } else if (operator.equals("/")) {
            ans = first / second;
        }
        return ans;
    }
}
