package racingcar.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {


    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int readCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        String inputCarCount = SCANNER.nextLine();
        if (!NUMBER_PATTERN.matcher(inputCarCount).matches()) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다.");
        }

        return Integer.parseInt(inputCarCount);
    }


    public static int readAttemptCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String inputTimes = SCANNER.nextLine();
        if (!NUMBER_PATTERN.matcher(inputTimes).matches()) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다.");
        }

        return Integer.parseInt(inputTimes);

    }





}
