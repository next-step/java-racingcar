package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final List<String> QUESTION = List.of("자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?");
    private final Scanner scanner = new Scanner(System.in);

    public List<Integer> input() {
        List<Integer> inputValues = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println(QUESTION.get(i));
            inputValues.add(scanner.nextInt());
        }
        scanner.close();
        return inputValues;
    }
}
