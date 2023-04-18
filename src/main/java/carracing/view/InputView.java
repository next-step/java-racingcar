package carracing.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)");
        return scanner.nextLine();
    }

    public int inputMoveNum() {
        System.out.println("자동차 이동 횟수를 입력하세요.");
        return scanner.nextInt();
    }
}
