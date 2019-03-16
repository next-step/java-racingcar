package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void printIntroduction() {
        System.out.println("실행결과");
    }

    public static void printBody(List<Car> cars) {
        cars.forEach(OutputView::showCarStatus);
        System.out.println();
    }

    private static void showCarStatus(Car car) {
        int position = car.getPosition();
        String name = car.getName();

        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        System.out.println(sb);
    }

    public static void printResult(List<String> winners) {
        System.out.print(String.join(", ", winners));
        System.out.println("가 최종 우승했습니다.");
    }
}