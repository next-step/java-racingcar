package RacingGame;

import java.util.Scanner;

class InputView {

    private static Scanner scanner;

    InputView() {
        this.scanner = new Scanner(System.in);
    }

    static int countTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    static String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }
}
