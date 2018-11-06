package racinggame.view.console;

import java.util.Scanner;

public class InputView {

    public static int inputTryCnt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        int tryCnt = scanner.nextInt();
        return tryCnt;
    }

    public static String[] inpputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String[] carName = scanner.nextLine().split(",");
        return carName;
    }

}
