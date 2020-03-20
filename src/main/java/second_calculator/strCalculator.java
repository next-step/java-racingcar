package second_calculator;
import java.util.Scanner;

public class strCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("입력 : ");

        String str = sc.nextLine();

        isBlank(str); //빈값여부

        int result = calculator(str);

        System.out.println("최종 값 : " + result);
    }


    public static int calculator(String str) {
        String[] inputArray = str.split(" "); // 빈값제거
        int result = Integer.parseInt(inputArray[0]);
        for (int i = 1; i < inputArray.length; i=i+2) {
            String symbol = inputArray[i];
            int val2 = Integer.parseInt(inputArray[i+1]);
            result = cal(result, symbol, val2);
        }

        return result;
    }

    public static int add(int input1, int input2) {
        return input1 + input2;
    }

    public static int substract(int input1, int input2) {
        return input1 - input2;
    }

    public static int multiply(int input1, int input2) {
        return input1 * input2;
    }

    public static int divide(int input1, int input2) {
        return input1/input2;
    }

    public static void isBlank(String input) {
        if(input == null || "".equals(input.replace(" ", ""))){
            throw new IllegalArgumentException();
        }
        return;
    }

    public static void isSymbol(String input) {
        switch (input){
            case "+" :
            case "-" :
            case "*" :
            case "/" :
                return;
            default: throw new IllegalArgumentException();
        }
    }

    public static int cal(int val1, String symbol, int val2) {
        int rtn = 0;

        isSymbol(symbol); //심볼 체크

        switch (symbol) {
            case "+":
                rtn = add(val1, val2);
                break;
            case "-":
                rtn = substract(val1, val2);
                break;
            case "*":
                rtn = multiply(val1, val2);
                break;
            case "/":
                rtn = divide(val1, val2);
                break;
        }
        return rtn;
    }
}
