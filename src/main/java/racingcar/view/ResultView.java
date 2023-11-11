package racingcar.view;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    public void viewGame(List<Car> cars) {
        for (Car car : cars){
            String printValue = car.getName() + " " + ": " + "-".repeat(car.getPosition());
            System.out.println(printValue);
        }
        System.out.println();
    }

    public void viewWinner(List<Car> winners) {
        String printWinner = "";
        for (Car winner : winners) {
            printWinner += winner.getName() + ", ";
        }
        printWinner = printWinner.substring(0, printWinner.length() - 2);
        System.out.println(printWinner + "가 최종 우승했습니다.");
    }

    public void view() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
