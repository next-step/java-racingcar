package racing;

public class RacingGameResultVIew {
    // 출력
    public static void racingResultView(RacingGame rg) {
        System.out.println("실행 결과");
        for (int i = 0; i < rg.getTime(); i++) {
            int[] resultMov = rg.move();

            for (int j = 0; j < resultMov.length; j++) {
                for (int k = 0; k < resultMov[j]; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
