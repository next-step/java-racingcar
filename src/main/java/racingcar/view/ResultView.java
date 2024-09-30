package racingcar.view;

import racingcar.model.Car;

public class ResultView {
    
    public static void showCarStatus(Car car) {
        System.out.print(car.showStatus());
        System.out.println();
    }

    public static void showResultDescription() {
        System.out.println("실행 결과");
    }

    public static void nextLine() {
        System.out.println();
    }
}
