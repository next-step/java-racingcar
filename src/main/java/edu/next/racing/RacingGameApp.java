/*
 * racinggame main class
 * 2020.05.14
 * version 1.0.0
 * 저작권 관련
 */
package edu.next.racing;

import edu.next.racing.controller.RacingController;

/**
 * 자동차 경주 메인 클래스
 *
 * @version 1.0.0
 * @author GwangJunChoi
 */
public class RacingGameApp {

    /** 자동차 경주 메인 */
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.play();
        racingController.displayResult();
    }

}
