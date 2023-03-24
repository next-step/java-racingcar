package racingCar.view;

import java.util.Scanner;

public class InputView {

    public static String getCarNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    public int getTryNo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(sc.nextLine());
    }
}
