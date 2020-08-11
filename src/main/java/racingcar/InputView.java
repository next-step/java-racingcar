package racingcar;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CARS_NAMING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_REPEAT_MESSAGE = "시도할 횟수는 몇 회 인가요?";

    private static Scanner sc = new Scanner(System.in);

    public static String makeCarsName() {
        System.out.println(INPUT_CARS_NAMING);
        return sc.nextLine();
    }

    public static int getCountOfRepeat() {
        System.out.println(INPUT_REPEAT_MESSAGE);
        return sc.nextInt();
    }
}
