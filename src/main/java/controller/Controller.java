package controller;

import domain.Car;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Controller {
    public static String getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return InputView.getCarNames();
    }

    public static int getPlayCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return InputView.getPlayCount();
    }

    public static void printCars(List<Car> cars) {
        ResultView.printCars(cars);
    }

    public static void printWinners(String winners) {
        ResultView.printWinners(winners);
    }
}
