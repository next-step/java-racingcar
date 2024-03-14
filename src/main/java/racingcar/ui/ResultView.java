package racingcar.ui;

import racingcar.model.Car;

import java.util.List;

public class ResultView {
    private static ResultView instance = new ResultView();

    private ResultView() {
        System.out.println("실행 결과");
    }

    public static ResultView getInstance() {
        return instance;
    }

    public void printMove(List<Car> carList) {
        carList.forEach(car -> printCarDistance(car));
    }

    private static void printCarDistance(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printLineBreak() {
        System.out.println();
    }

}
