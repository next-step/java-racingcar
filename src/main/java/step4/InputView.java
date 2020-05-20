package step4;

import java.util.Scanner;

public final class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static InputView create() {
        return new InputView();
    }

    public String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int getTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
