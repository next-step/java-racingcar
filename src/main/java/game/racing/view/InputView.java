package game.racing.view;

import java.util.Scanner;

public class InputView {
    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return new Scanner(System.in).nextLine();
    }

    public static int getTryNo() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
}
