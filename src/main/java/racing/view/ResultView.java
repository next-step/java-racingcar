package racing.view;

import racing.model.Car;

import java.util.List;

public class ResultView {
    private ResultView() {

    }

    public static void printResultTitle() {
        System.out.println("실행 결과");
    }

    public static void showRacingProcess(List<Car> cars) {
        for (Car car : cars) {
            printSkidMark(car);
            System.out.println(car.getPosition());
        }
        System.out.println();
    }

    private static void printSkidMark(Car car) {
        String skidMark = "";
        for (int i = 0; i < car.getPosition(); i++) {
            skidMark += car.getTireMark();
        }
        System.out.println(skidMark);
    }
}
