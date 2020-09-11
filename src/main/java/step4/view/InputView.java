package step4.view;

import java.util.Scanner;

public class InputView {
    public static int numberOfAttempts() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        System.out.println();
        System.out.println("실행결과");
        return result;
    }

    public static String inputNameView() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        return result;
    }

    public static void inputTest(String names, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
        sb.append(names);
        sb.append("\n");
        sb.append("시도할 회수는 몇회인가요?\n");
        sb.append(count);
        sb.append("\n\n");
        sb.append("실행결과");
        System.out.println(sb.toString());
    }
}
