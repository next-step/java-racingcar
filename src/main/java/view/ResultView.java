package view;

import domain.Position;

public class ResultView {

    public static void printPosition(Position position) {
        printMessage(position.toString());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}