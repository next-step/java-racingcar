package racingcar.view;

import racingcar.constant.Question;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final int MIN_ROUND = 1;

    private InputView() {
    }

    public static int roundScan() {
        System.out.println(Question.ROUND.getQuestion());
        return roundValidCheck(scanner.nextInt());
    }

    public static List<String> carNamesScan() {
        System.out.println(Question.CAR_NAME.getQuestion());
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static int roundValidCheck(int round) {
        if (round < MIN_ROUND) {
            throw new RuntimeException("1이상 부터 가능합니다.");
        }
        return round;
    }


}
