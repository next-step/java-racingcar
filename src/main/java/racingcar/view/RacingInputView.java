package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingInputView {
    public static final String COMMA_REGEX = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        String text = scanner.nextLine();
        return split(text, COMMA_REGEX);
    }
    public static int getTryNums() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public static List<String> split(String text, String regex) {
        String[] splitText = text.split(regex);
        return Arrays.asList(splitText);
    }
}
