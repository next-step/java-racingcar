package com.game.racing.view;

public class ResultView {

    // Suppresses default constructor, ensuring non-instantiability.
    private ResultView() {
    }

    public static final String RESULT_MESSAGE_OF_GAME_END = "실행결과";
    public static final String DASH_STRING = "-";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE_OF_GAME_END);
    }

    public static String printDashByInt(int intVal) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < intVal; i++) {
            System.out.print(DASH_STRING);
            result.append(DASH_STRING);
        }
        System.out.println();
        return result.toString();
    }

}
