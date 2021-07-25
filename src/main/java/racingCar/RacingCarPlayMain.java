/*
 *   Class name : RacingCarPlayMain.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingCar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 해당 메소드의 기능은 자동차 경주 게임을 시작합니다.
 * 자동차의 수와 , 이동하는 횟수를 입력받습니다.
 */
public class RacingCarPlayMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("자동차 대수는 몇 대 인가요 ?");
        int carCount = Integer.parseInt(br.readLine());
        System.out.println("시도할 회수는 몇 회 인가요 ?");
        int moveCount = Integer.parseInt(br.readLine());

        RacingCar racingCar = new RacingCar(carCount ,moveCount);
        System.out.println("실행 결과");
        racingCar.racingStart(racingCar.readyCar());

    }
}
