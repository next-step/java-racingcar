
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] ar = input.split(" ");
        List<Integer> nums = new ArrayList<>();
        List<String> calculate = new ArrayList<>();

        for (int i = 0; i < ar.length; i++) {
            if (i % 2 == 0) {
                nums.add(Integer.parseInt(ar[i]));
            } else {
                calculate.add(ar[i]);
            }
        }

        int result = nums.get(0);
        for(int i = 0; i < calculate.size(); i++) {
            switch (calculate.get(i)) {
                case "+":
                    result = addition(result, nums.get(i+1));
                    break;
                case "-":
                    result = subtraction(result, nums.get(i+1));
                    break;
                case "*":
                    result = multiplication(result, nums.get(i+1));
                    break;
                case "/":
                    result = division(result, nums.get(i+1));
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        System.out.println(result);
    }

    public static int addition(int num, int result) {
        return result + num;
    }

    public static int subtraction(int num, int result) {
        return result - num;
    }

    public static int multiplication(int num, int result) {
        return result * num;
    }

    public static int division(int result, int num) {
        return result / num;
    }

}


