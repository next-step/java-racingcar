package calculator;

public class StringCalculator {
    public static int calc(String input) {
        String[] arr = input.split(" ");
        int size = arr.length;
        if (size < 3) {
            throw new IllegalArgumentException();
        }
        Operator operator;
        int num2;
        int answer = Integer.parseInt(arr[0]);
        for (int i = 1; i < size - 1; i += 2) {
            operator = Operator.valueOfString(arr[i]);
            num2 = Integer.parseInt(arr[i + 1]);
            answer = operator.execute(answer, num2);
        }
        return answer;
    }
}
