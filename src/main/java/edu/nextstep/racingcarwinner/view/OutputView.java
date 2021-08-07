/*
 * edu.nextstep.racingcarwinner.view.OutputView.java
 * 0.1 2021.08.07 18:24
 * 해당 클래스의 경우 TDD, CleanCode with Java 수업의 RacingCar step4에 해당됩니다.
 */

package edu.nextstep.racingcarwinner.view;

import edu.nextstep.racingcarwinner.domain.Car;
import edu.nextstep.racingcarwinner.domain.RacingCars;

import java.util.List;

public class OutputView {

    public void printStartSign() {
        System.out.println("실행 결과");
    }

    public void printOneRound(RacingCars racingCars) {
        List<Car> carList = racingCars.getRacingCars();
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            System.out.println(makeDistanceView("-", car.getDistance()));
        }
        System.out.println();

    }

    private String makeDistanceView(String s, int distance) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            result.append(s);
        }
        return result.toString();
    }


    public void printWinner(List<Car> winners) {
        StringBuilder result = new StringBuilder();
        for (Car car : winners) {
            result.append(", ").append(car.getName());
        }
        result.delete(0, 2);
        result.append("가 최종 우승했습니다.");
        System.out.println(result.toString());
    }


}
