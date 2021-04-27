package calculator;

public class Calculation {
    public String[] numbers;
    int result = 0;

    int add(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int mul(int a, int b) {
        return a * b;
    }

    int div(int a, int b) {
        return a / b;
    }

    void test() {
        String input = "2 + 3 * 4 / 2";
        numbers = input.split(" ");
        for (int i = 0; i < numbers.length - 1; i++) {
            contains(i);
        }
        System.out.println(numbers[numbers.length - 1]);
    }

    void contains(int index) {
        if (numbers[index].equals("+") || numbers[index].equals("-") || numbers[index].equals("*") || numbers[index].equals("/")) {
            int val1 = Integer.parseInt(numbers[index - 1]);
            int val2 = Integer.parseInt(numbers[index + 1]);
            numbers[index + 1] = calculation(numbers[index], val1, val2);
        }
    }

    public String calculation(String operator, int val1, int val2) {
        int temp = 0;
        if (operator.equals("+")) {
            temp = result + add(val1, val2);
        } else if (operator.equals("-")) {
            temp = result + sub(val1, val2);
        } else if (operator.equals("*")) {
            temp = result + mul(val1, val2);
        } else {
            temp = result + div(val1, val2);
        }
        return Integer.toString(temp);
    }
}
