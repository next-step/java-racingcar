package racing;

import java.util.Scanner;

class RacingGameScanner {
    public static int[] enter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대인가요?");
        int carCount = sc.nextInt();

        if (carCount <= 1) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다");
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int stageCount = sc.nextInt();

        System.out.println();

        if (stageCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다");
        }

        sc.close();
        return new int[]{stageCount, carCount};
    }
}
