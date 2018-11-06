package racingcar;

public class ResultView {

    /**
     * @param carPositions
     * 결과 출력
     */
    public static void showResult(int[] carPositions) {
        for (int i=0; i<carPositions.length; i++) {
            drawDash(carPositions[i]);
            System.out.println();
        }
    }

    /**
     * @param carPosition
     * 차량 현재 위치를 그린다.
     */
    private static void drawDash(int carPosition) {
        for (int j = 0; j< carPosition; j++) {
            System.out.print("-");
        }
    }
}
