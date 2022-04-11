package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    static final Scanner scanner = new Scanner(System.in);

    public List<Integer> printInput() {
        List<Integer> inputData = new ArrayList<>();
        inputData.add(enterTheNumberOfCars());
        inputData.add(enterTheNumberOfTry());

        return inputData;
    }

    private int enterTheNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private int enterTheNumberOfTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
