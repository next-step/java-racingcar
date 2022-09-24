package racing.application.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분.");
        return scanner.nextLine();
    }

    public int moveCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }
}
