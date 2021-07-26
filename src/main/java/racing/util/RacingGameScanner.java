package racing.util;

import java.util.Scanner;

public class RacingGameScanner {
    public static String[] enter() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String names = sc.nextLine();

            System.out.println("시도할 회수는 몇회인가요?");
            String stageCount = sc.nextLine();

            System.out.println();
            return new String[]{names, stageCount};
        }
    }
}
