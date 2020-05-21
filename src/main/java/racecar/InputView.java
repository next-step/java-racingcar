package racecar;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static int askRepeatCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int repeatCount = scanner.nextInt();
        return repeatCount;
    }

    public static String[] askCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] carNames = input.split(",");
        return carNames;
    }
}
