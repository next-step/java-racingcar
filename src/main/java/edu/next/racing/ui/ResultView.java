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
import java.util.List;

/**
 * 레이싱 게임 결과값 출력 ui 클래스
 *
 * @version 1.0.0
 * @author GwangJunChoi
 */
public class ResultView {

    public void displayRacingResult(String[] resultString) {
        System.out.println("결과 출력");
        for (String result : resultString){
            System.out.println(result);
        }
    }

}
