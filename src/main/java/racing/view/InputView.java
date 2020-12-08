package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_TIMES = "시도할 회수는 몇 회 인가요?";
    private static final String COMMA = ",";


    public static List<String> carNamesMessage() {
        System.out.println(CAR_NAMES_MESSAGE);
        return inputSplit(SCANNER.nextLine());
    }

    public static int tryTimes() {
        System.out.println(TRY_TIMES);
        return SCANNER.nextInt();
    }

    public static List<String> inputSplit(String inputString) {
        return Arrays.asList(inputString.split(COMMA));
    }
}
