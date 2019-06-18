package RacingGame;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int countTime() {
        System.out.println("시도할 회수는 몇 회 인가요?\n");
        return scanner.nextInt();
    }

    public String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
        return scanner.nextLine();
    }
}
