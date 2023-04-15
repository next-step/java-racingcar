package io;

import domain.Car;

import java.util.List;

public class ConsoleWriter {
    public static void writeHeader() {
        System.out.println("실행 결과");
    }

    public static void writeGameInformation(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(getCarAsString(car));
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void writeWinner(List<String> winner) {
        System.out.println(String.join(",", winner) + "가 최종 우승했습니다.");
    }

    private ConsoleWriter() {
    }
    private static String getCarAsString(Car car) {
        return car.getOwner() + " : " + "-".repeat(Math.max(0, car.getDistance()));
    }
}
