import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 입력 받기
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] inputs = input.split(" ");

        // 숫자
        List<Integer> nums = new ArrayList<>();
        // 연산자
        List<String> operators = new ArrayList<>();

        // 숫자, 연산자 분리
        for (int i = 0; i < inputs.length; i++) {
            if (i % 2 == 0) {
                nums.add(Integer.parseInt(inputs[i]));
            } else {
                operators.add(inputs[i]);
            }
        }

        // 계산기 작동
        Calculator calculator = new Calculator();
        int result = calculator.calculate(nums, operators);
        System.out.println(result);


    }
}
