package view;

import java.util.List;

public class ResultView {

    public static void printPosition(String name, String position) {
        printMessage(name + " : " + position);
    }

    public static void printWinner(List<String> winners) {
        printMessage(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}