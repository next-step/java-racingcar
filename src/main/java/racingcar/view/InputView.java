package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static String TEXT_QUESTION_CAR_NAME_JOIN_RACE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String TEXT_QUESTION_RACING_TIME = "시도할 회수는 몇 회 인가요?";

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static String inputCarCountJoinRace() {
        System.out.println(TEXT_QUESTION_CAR_NAME_JOIN_RACE);
        return scanner.nextLine();
    }

    public static int inputRaceTime() {
        System.out.println(TEXT_QUESTION_RACING_TIME);
        return scanner.nextInt();
    }
}
