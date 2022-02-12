package racing.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static String getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    public static int getTotalRoundNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(sc.nextLine());
    }
}
