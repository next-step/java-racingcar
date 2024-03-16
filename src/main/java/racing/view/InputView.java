package racing.view;

import racing.domain.RacingCars;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String askNumberOfCarParticipants() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 " + RacingCars.NAME_DELIMITER + "를 기준으로 구분)");
        return scanner.nextLine();
    }

    public static String askNumberOfAttempt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextLine();
    }
}
