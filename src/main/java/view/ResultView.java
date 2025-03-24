package view;

import java.util.List;

import domain.Position;

public class ResultView {

    public static void printCurrentPositions(List<Position> positions) {
        for (Position position : positions) {
            printMessage(position.toString());
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}