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

    private final static String LINE = "-";
    private List<Car> resultCars;
    private int resultTime;

    public ResultView(List<Car> ResultCars, int time) {
        this.resultCars = ResultCars;
        this.resultTime = time;
    }

    public void displayRacingResult() {
        System.out.println("결과 출력");
        drawStartLine(this.resultCars.size());
        for (int i = 0; i < this.resultTime; i++) {
            System.out.println();
            displayCarLine(i);
        }
    }

    private void drawStartLine(int carsCount) {
        for (int i = 0; i < carsCount; i++) {
            drawLine(1);
        }
    }

    private void displayCarLine(int recordNumber) {
        for (Car car : this.resultCars){
            drawLine(car.getRecord(recordNumber));
        }
    }

    private void drawLine(int lineNumber) {
        for (int i = 0; i < lineNumber; i++) {
            System.out.print(LINE);
        }
        System.out.println();
    }

}
