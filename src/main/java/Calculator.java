import java.util.LinkedList;
import java.util.List;

public class Calculator {

    public static int calc(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        List<Integer> numbers = new LinkedList<>();
        List<String> operators = new LinkedList<>();

        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (i % 2 == 0) {
                numbers.add(Integer.parseInt(split[i]));
            }
            if (i % 2 == 1) {
                operators.add(split[i]);
            }
        }

        int ans = calc(numbers, operators);
        return ans;
    }

    private static int calc(List<Integer> numbers, List<String> operators) {
        for (int i = 0; i < operators.size(); i++) {
            int first = numbers.remove(0);
            int second = numbers.remove(0);
            if (operators.get(i).equals("+")) {
                numbers.add(0, first + second);
            } else if (operators.get(i).equals("-")) {
                numbers.add(0, first - second);
            } else if (operators.get(i).equals("*")) {
                numbers.add(0, first * second);
            } else if (operators.get(i).equals("/")) {
                numbers.add(0, first / second);
            } else {
                throw new IllegalArgumentException();
            }
        }
        return numbers.get(0);
    }

}
