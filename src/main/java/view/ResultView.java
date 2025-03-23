package view;

import java.util.List;

public class ResultView {

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
