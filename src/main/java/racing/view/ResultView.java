package racing.view;

import racing.model.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private ResultView() {

    }

    public static void printResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            printSkidMark(car);
        }
        System.out.println();
    }

    private static void printSkidMark(Car car) {
        String skidMark = car.getName() + " : ";
        for (int i = 0; i < car.getPosition(); i++) {
            skidMark += car.getTireMark();
        }
        System.out.println(skidMark);
    }

    public static void printWinner(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.getName());
        }
        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }
}
