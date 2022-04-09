package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";

    public int inputCarCount() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);

        return SCANNER.nextInt();
    }

}
