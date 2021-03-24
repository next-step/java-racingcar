package step5.view;


import step5.domain.Car;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void print(List<Car> cars) {
        for (int i = 0; i < cars.size(); ++i) {
            print(cars.get(i));
        }
    }

    private static void print(Car car) {
        StringBuilder sb = new StringBuilder();

        System.out.print(car.getCarName() + ": ");
        for (int i = 0; i < car.getPosition().getPosition(); ++i) {
            sb.append("-");
        }

        System.out.println(sb.toString());
    }

    public static void ResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public static void printWinner(String winnerList) {
        System.out.println(winnerList + "가 우승했습니다.");
    }
}
