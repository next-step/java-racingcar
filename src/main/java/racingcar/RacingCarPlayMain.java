/*
 *   Class name : RacingCarPlayMain.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 해당 메소드의 기능은 자동차 경주 게임을 시작합니다.
 * 자동차의 수와 , 이동하는 횟수를 입력받습니다.
 */
public class RacingCarPlayMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        String[] carNames = br.readLine().replaceAll(" ", "").split(",");
        System.out.println("시도할 회수는 몇 회 인가요 ?");
        int moveCount = Integer.parseInt(br.readLine());

        RacingCar racingCar = new RacingCar(carNames ,moveCount);
        System.out.println("실행 결과");
        List<Car> carsAfterTheRace = racingCar.doRacingStart(racingCar.createAsCarsNumberOfEnteredByUser());
        List<Car> winners = racingCar.whoIsWinner(carsAfterTheRace);

        StringBuffer sb = new StringBuffer();
        for (Car winner : winners) {
            sb.append(winner.getCarName() + ",");
        }
        System.out.println(sb.toString().substring(0,sb.toString().lastIndexOf(',')) + "가 최종 우승했습니다.");

    }
}
