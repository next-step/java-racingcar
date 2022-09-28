package com.game.racing.view;

import com.game.racing.car.Car;

public class ResultView {

    private ResultView() {
        throw new IllegalStateException("ResultView 클래스는 인스턴스화할 수 없습니다!");
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

    public static void printCarCurrentPosition(Car car) {
        printDashByInt(car.getPosition());
    }

    public static void printNewLine() {
        System.out.println();
    }
}
