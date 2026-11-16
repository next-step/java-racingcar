package racingcar.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {


    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String 자동차_대수는_몇_대_인가요 = "자동차 대수는 몇 대 인가요?";
    public static final String 숫자가_아닌_값이_포함되어_있습니다 = "숫자가 아닌 값이 포함되어 있습니다.";
    public static final String 시도할_회수는_몇_회_인가요 = "시도할 회수는 몇 회 인가요?";

    public static int readCarCount() {
        System.out.println(자동차_대수는_몇_대_인가요);
        String inputCarCount = SCANNER.nextLine();
        if (!NUMBER_PATTERN.matcher(inputCarCount).matches()) {
            throw new RuntimeException(숫자가_아닌_값이_포함되어_있습니다);
        }

        return Integer.parseInt(inputCarCount);
    }


    public static int readAttemptCount() {
        System.out.println(시도할_회수는_몇_회_인가요);
        String inputTimes = SCANNER.nextLine();
        if (!NUMBER_PATTERN.matcher(inputTimes).matches()) {
            throw new RuntimeException(숫자가_아닌_값이_포함되어_있습니다);
        }

        return Integer.parseInt(inputTimes);

    }


}
