package io;

import domain.Car;

import java.util.List;

public class ConsoleWriter {
    public static void writeHeader() {
        System.out.println("실행 결과");
    }

    public static void writeGameInformation(List<Car> cars) {
        System.out.println(ResultView.getGameAsString(cars));
    }

    public static void writeWinner(List<String> winner) {
        System.out.println(String.join(",", winner) + "가 최종 우승했습니다.");
    }

    private ConsoleWriter() {
    }
}
