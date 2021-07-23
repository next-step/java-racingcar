package racing;

import java.util.Scanner;

class RacingGameScanner {
    public static int[] enter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대인가요?");
        int racerCount = sc.nextInt();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int stageCount = sc.nextInt();

        System.out.println();

        sc.close();
        return new int[]{stageCount, racerCount};
    }
}
