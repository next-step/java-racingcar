/*
 *   Class name : RacingCarResultView.java
 *   Version : 0.0.1
 *   Date : 2021/07/31
 */

package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * RacingCar에 필요한 UI를 제공합니다.
 */
public class RacingCarResultView {

    public String[] getCarNames(BufferedReader br) throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        String[] carNames = br.readLine().replaceAll(" ", "").split(",");
        return carNames;
    }

    public int getMoveCount(BufferedReader br) throws IOException {
        System.out.println("시도할 회수는 몇 회 인가요 ?");
        int moveCount = Integer.parseInt(br.readLine());
        return moveCount;
    }

    /**
     * 자동차들이 이동하는것을 그립니다.
     * @param cars
     */
    public void drawCarMoving(List<Car> cars) {
        for (Car car : cars) {
            drawUI(car);
        }
        System.out.println();
    }

    /**
     * 자동차가 움직인 만큼 UI 를 그립니다.
     * @param car
     */
    public void drawUI(Car car) {
        System.out.printf(car.getCarName() + " : ");
        for (int j = 0; j < car.getCurrentLocation(); j++) {
            System.out.printf("-");
        }
        System.out.println();
    }

    public void drawRacingResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    /**
     * RacingCar 승자를 그립니다.
     * @param winners
     */
    public void drawWinnerView(List<Car> winners) {
        StringBuffer sb = new StringBuffer();

        for (Car winner : winners) {
            sb.append(winner.getCarName() + ",");
        }
        System.out.println(sb.toString().substring(0,sb.toString().lastIndexOf(',')) + "가 최종 우승했습니다.");
    }
}
