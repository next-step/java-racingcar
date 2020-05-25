/*
 * resultview class 레이싱 결과값 출력
 * 2020.05.15
 * version 1.0.0
 * 저작권 관련
 */

package edu.next.racing.ui;

import edu.next.racing.model.Car;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 레이싱 게임 결과값 출력 ui 클래스
 *
 * @version 1.0.0
 * @author GwangJunChoi
 */
public class ResultView {

    private final static String LINE = "-";
    private List<Car> resultCars;
    private List<Car> winner;
    private int resultTime;
    private StringBuilder uiBuilder = new StringBuilder();

    public ResultView(List<Car> ResultCars, int time, List<Car> winner) {
        this.resultCars = ResultCars;
        this.resultTime = time;
        this.winner = winner;
    }

    public void displayRacingResult() {
        System.out.println("결과 출력");
        for (int i = 0; i <= this.resultTime; i++) {
            System.out.println();
            displayCarLine(i);
        }
        displayWinner();
    }

    private void displayCarLine(int recordNumber) {
        for (Car car : this.resultCars){
            drawLine(car.getName(), car.getRecord(recordNumber));
        }
    }

    private void displayWinner() {
        System.out.println(this.winner.stream()
                            .map( car -> car.getName() )
                            .collect(Collectors.joining( "," )) + "가 최종 우승했습니다.");
    }

    private void drawLine(String name, int lineNumber) {
        uiBuilder.setLength(0);
        uiBuilder.append(name + " : ");
        for (int i = 0; i < lineNumber; i++) {
            uiBuilder.append(LINE);
        }
        System.out.println(uiBuilder.toString());
    }

}
