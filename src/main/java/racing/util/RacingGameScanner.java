package racing.util;

import java.util.Scanner;

public class RacingGameScanner {
    public static String enterNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = sc.nextLine();
        return names;
    }

    public static int enterStageCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        int stageCount = sc.nextInt();
        System.out.println();
        sc.close();
        return stageCount;
    }
}
