/*
 * resultview class 레이싱 결과값 출력
 * 2020.05.15
 * version 1.0.0
 * 저작권 관련
 */

package edu.next.racing.ui;

import edu.next.racing.model.Car;
import edu.next.racing.model.RacingGame;

import java.util.ArrayList;

/**
 * 레이싱 게임 결과값 출력 ui 클래스
 *
 * @version 1.0.0
 * @author GwangJunChoi
 */
public class ResultView {


    public void displayRacingResult(RacingGame racingGame) {
        int time = racingGame.getTime();

        System.out.println("결과 출력");
        for (int i = 0; i < time; i++) {
            this.displayCarPosition(racingGame.move());
            System.out.println();
        }
    }

    private void displayCarPosition(ArrayList<Car> cars) {
        for (Car car : cars) {
            this.displayCarLine(car.getPosition());
            System.out.println();
        }
    }

    private void displayCarLine(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

}
