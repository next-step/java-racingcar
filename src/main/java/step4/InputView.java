package step4;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private String carNames;
    private static int tryCnt;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public void initInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNames = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        tryCnt = scanner.nextInt();
    }

    public String getCarNames() {
        return carNames;
    }

    public static int getTryCnt() {
        return tryCnt;
    }
}
