package racing.view;

import java.util.Scanner;

public class RacingInputView {

    public static String carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = createScanner();
        return scanner.nextLine();
    }

    public static int raceCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        Scanner scanner = createScanner();
        return scanner.nextInt();
    }

    private static Scanner createScanner() {
        return new Scanner(System.in);
    }
}
