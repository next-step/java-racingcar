package racinggame.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputGame {

    private final int MINIMUM_INPUT_VALUE = 0;

    public List<Integer> inputData() {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputCount = new ArrayList<>();
        System.out.println("자동차 대수는 몇 대 인가요?");
        inputCount.add(scanner.nextInt());

        System.out.println("시도할 횟수는 몇 회 인가요?");
        inputCount.add(scanner.nextInt());

        if(inputCount.size() < MINIMUM_INPUT_VALUE) {
            throw new IllegalArgumentException();
        }

        return inputCount;
    }
}
