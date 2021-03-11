package step4;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(자동차 이름은 5자를 초과할 수 없습니다.)");

        return scanner.nextLine();
    }

    public int inputAttempt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

}
