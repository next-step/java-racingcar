package view;

import domain.Car;
import domain.Cars;

import java.util.Scanner;
import java.util.stream.IntStream;

public class OutputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printWinner(String winnerCarNames) {
        System.out.println(winnerCarNames + "가 최종 우승 했습니다.");
    }

    public static void printLength(String name, int length) {
        System.out.print(name + " : ");
        IntStream.range(0, length)
                .forEach(e -> System.out.print("-"));
    }
}
