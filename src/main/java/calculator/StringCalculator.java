package calculator;

public class StringCalculator {
    public static int calc(String input){
        String[] arr = input.split(" ");
        int size = arr.length;
        if(size < 3){
            throw new IllegalArgumentException();
        }
        Operator operator;
        int num2;
        int answer = Integer.parseInt(arr[0]);
        for(int i = 1; i < size - 1; i += 2){
            operator = Operator.valueOfString(arr[i]);
            num2 = Integer.parseInt(arr[i+1]);
            answer = calcFromOperator(operator, answer, num2);
        }
        return answer;
    }

    private static int calcFromOperator(Operator operator, int a, int b){
        if(operator.equals(Operator.ADD)){
            return add(a, b);
        }
        if(operator.equals(Operator.SUB)){
            return sub(a, b);
        }
        if(operator.equals(Operator.MUL)){
            return mul(a, b);
        }
        return div(a, b);
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
