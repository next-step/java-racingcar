package calculator;

public class StringCalculator {
    public static int calc(String input){
        String[] arr = input.split(" ");
        if(arr.length == 0){
            throw new IllegalArgumentException();
        }
        int num1 = Integer.parseInt(arr[0]);
        String operator = arr[1];
        int num2 = Integer.parseInt(arr[2]);
        int result = 0;

        switch (operator){
            case "+":
                result = add(num1,num2);
                break;
            case "-":
                result = sub(num1,num2);
                break;
            case "*":
                result = mul(num1,num2);
                break;
            case "/":
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
