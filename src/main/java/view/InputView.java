package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static int inputRaceTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return input.nextInt();
    }

    public static String inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return input.nextLine();
    }

}
