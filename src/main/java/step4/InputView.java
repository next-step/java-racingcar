package step4;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRIAL_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getRounds() {
        print(TRIAL_MESSAGE);
        return scanner.nextInt();
    }

    public static Cars getCars() {
        print(CAR_NAMES_MESSAGE);
        return new Cars(scanner.next());
    }

    private static void print(String carNamesMessage) {
        System.out.println(carNamesMessage);
    }
}
