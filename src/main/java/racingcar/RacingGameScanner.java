package racingcar;

import java.util.Scanner;

class RacingGameScanner {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_COUNT = "자동차 대수는 몇 대인가요?";
    private static final String STAGE_COUNT = "시도할 횟수는 몇 회인가요?";

    public static int enterCarCount() {
        System.out.println(CAR_COUNT);
        int carCount = SCANNER.nextInt();
        if (carCount <= 1) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다");
        }
        return carCount;
    }

    public static int enterStageCount() {
        System.out.println(STAGE_COUNT);
        int stageCount = SCANNER.nextInt();
        if (stageCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다");
        }
        return stageCount;
    }
}
