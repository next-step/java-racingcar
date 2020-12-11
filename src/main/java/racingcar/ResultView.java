package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String RESULT_DASH = "-";

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

    /**
     * 현재 결과를 출력합니다
     */
    public void printResultWithName(RacingCarDriver racingCarDriver) {
        for (RacingCar racingCar : racingCarDriver.getRacingCars()) {
            System.out.print(racingCar.getName() + " : ");
            this.printDash(racingCar.getDistance());
        }
    }

    /**
     * 우승자를 출력합니다.
     * @param racingCarDriver
     */
    public void printWinner(RacingCarDriver racingCarDriver) {
        List<String> winners = racingCarDriver.getWinner();
        for (int i = 0; i < winners.size(); i++) {
            this.printDelimiter(i);
            System.out.print(winners.get(i));
        }
        System.out.println("가 최종 우승했습니다.");
    }

    /**
     * 우승자가 여러명일 경우, 우승자 이름 사이에 구분자를 출력합니다
     * @param i
     */
    private void printDelimiter(int i) {
        if(i > 0) {
            System.out.print(" , ");
        }
    }

}
