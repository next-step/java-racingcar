package racing.view;

import java.util.Scanner;

public class CarRacingInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.nextLine();
    }

    public static int countOfRace() {
        System.out.println("시도할 회수는 몇회인가요?");
        return SCANNER.nextInt();
    }
}
