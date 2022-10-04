package com.game.racing.view;

import com.game.racing.domain.car.Car;

import java.util.List;

public class ResultView {
    public static final String RESULT_MESSAGE_OF_GAME_END = "\n실행 결과";
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
        StringBuilder resultMessage = new StringBuilder();
        for (int index = 1; index <= size; index++) {
            resultMessage.append(racingWinners.get(index - 1).getName());
            appendComma(size, resultMessage, index);
        }
        resultMessage.append("가 최종 우승했습니다.");
        System.out.println(resultMessage);
    }

    private static void appendComma(int size, StringBuilder resultMessage, int index) {
        if (size != index) {
            resultMessage.append(", ");
        }
    }
}
