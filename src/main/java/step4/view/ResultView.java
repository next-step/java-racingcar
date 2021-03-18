package step4.view;

import step4.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void print(Car car) {
        StringBuilder sb = new StringBuilder();

        System.out.print(car.getCarName() + " : ");
        for (int i = 0; i < car.getDistance(); ++i) {
            sb.append("-");
        }

        System.out.println(sb.toString());
    }

    public static void printWinner(String winnerList) {
        System.out.println(winnerList + "가 우승했습니다.");
    }
}
