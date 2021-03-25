package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Play {

    public void play() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        setting(input);
    }

    public int setting(String input) {
        String[] inputs = input.split(" ");
        List<Integer> nums = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        for (int i = 0; i < inputs.length; i++) {
            if (i % 2 == 0) {
                nums.add(Integer.parseInt(inputs[i]));
            } else {
                operators.add(inputs[i]);
            }
        }

        Calculator calculator = new Calculator();
        return calculator.calculate(nums, operators);
    }
}
