/*
 * racinggame main class
 * 2020.05.14
 * version 1.0.0
 * 저작권 관련
 */
package edu.next.racing;

import edu.next.racing.model.Car;
import edu.next.racing.model.RacingGame;
import edu.next.racing.ui.InputView;
import edu.next.racing.ui.ResultView;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 자동차 경주 메인 클래스
 *
 * @version 1.0.0
 * @author GwangJunChoi
 */
public class MainView {

    /** 자동차 경주 메인 */
    public static void main(String[] args) {

        /** input ui */
        InputView inputView = new InputView();
        /** racingGame model */
        RacingGame racingGame = new RacingGame();
        /** result ui */
        ResultView resultView = new ResultView();
        /** car list */
        ArrayList<Car> cars = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        inputView.displayCarCountInputUi();     /** racingGame objects execute */
        racingGame.setCars(sc.nextInt());       /** racingGame objects execute */
        inputView.displayRacingLoopInputUi();   /** racingGame objects execute */
        racingGame.setTime(sc.nextInt());       /** racingGame objects execute */

        /** 자동차 레이싱 결과 출력 */
        resultView.displayRacingResult(racingGame);

    }

}
