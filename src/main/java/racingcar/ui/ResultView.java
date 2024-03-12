package racingcar.ui;

import racingcar.Car;

public class ResultView {
    private static ResultView instance = new ResultView();

    private ResultView() {
        System.out.println("실행 결과");
    }

    public static ResultView getInstance() {
        return instance;
    }

    public void printMove(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printLineBreak() {
        System.out.println();
    }

}
