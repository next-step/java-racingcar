package step4.view;

import java.util.Scanner;

public class InputView {
    public int numberOfAttempts() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        System.out.println();
        System.out.println("실행결과");
        return result;
    }

    public String inputNameView() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        return result;
    }

    public static void inputTest(String names, int count) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        System.out.println(names);
        System.out.println("시도할 회수는 몇회인가요?");
        System.out.println(count);
        System.out.println();
        System.out.println("실행결과");
    }

}
