package com.game.racing.view;

import com.game.racing.car.Car;

import java.util.List;

public class ResultView {
    public static final String RESULT_MESSAGE_OF_GAME_END = "실행결과";
    public static final String DASH_STRING = "-";

    private ResultView() {
        throw new IllegalStateException("ResultView 클래스는 인스턴스화할 수 없습니다!");
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE_OF_GAME_END);
    }

    public static void printCarNameAndPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition().get(); i++) {
            System.out.print(DASH_STRING);
        }
        System.out.println();
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinner(List<Car> racingWinners) {
        int size = racingWinners.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            sb.append(racingWinners.get(i - 1).getName());
            appendComma(size, sb, i);
        }
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }

    private static void appendComma(int size, StringBuilder sb, int i) {
        if (size != i) {
            sb.append(", ");
        }
    }
}
