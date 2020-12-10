package racingcar;

public class ResultView {

    private static final String RESULT_DASH = "-";

    /**
     * 현재 결과를 출력합니다
     */
    public void printResult(RacingCarDriver racingCarController) {
        for (int distance : racingCarController.getNowDistance()) {
            this.printDash(distance);
        }
    }

    /**
     * 주어진 거리만큼 '-'를 출력합니다.
     * @param distance
     */
    private void printDash(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(ResultView.RESULT_DASH);
        }
        System.out.println();
    }

    /**
     * 경주가 시작되어 실행결과를 보여 줄 때 출력합니다.
     */
    public void printStartResult() {
        System.out.println("실행 결과");
    }

    /**
     * 하나의 라운드가 종료 될 때 한줄을 띄워줍니다.
     */
    public void printEndRound() {
        System.out.println();
    }
}
