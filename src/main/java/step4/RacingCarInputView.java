package step4;

import java.util.Scanner;

public class RacingCarInputView {

    private static Scanner scanner;

    static void initiateScanner() {
        scanner = new Scanner(System.in);
    }

    static String scanCarInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    static int scanNumberOfRace() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfRace = scanner.nextInt();
        scanner.nextLine();

        return numberOfRace;
    }
}
