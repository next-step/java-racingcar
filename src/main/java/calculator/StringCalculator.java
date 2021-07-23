package calculator;

public class StringCalculator {
    public static int calc(String input){
        String[] arr = input.split(" ");
        if(arr.length == 0){
            throw new IllegalArgumentException();
        }
        int num1 = Integer.parseInt(arr[0]);
        Operator operator = Operator.valueOf(arr[1]);
        int num2 = Integer.parseInt(arr[2]);
        int result = 0;

        switch (operator){
            case ADD:
                result = add(num1,num2);
                break;
            case SUB:
                result = sub(num1,num2);
                break;
            case MUL:
                result = mul(num1,num2);
                break;
            case DIV:
                result = div(num1,num2);
        }
        return result;
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int sub(int a, int b) {
        return a - b;
    }

    private static int mul(int a, int b) {
        return a * b;
    }

    private static int div(int a, int b) {
        return a / b;
    }
}
