package racecar;

import java.util.List;

public class ResultView {

    private ResultView() {
        System.out.println("\n실행 결과");
    }

    public static void printStatus(Car car) {
        System.out.println(car.printStatus());
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승 했습니다.");
    }
}
