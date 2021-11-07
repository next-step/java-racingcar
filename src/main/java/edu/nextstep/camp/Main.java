package edu.nextstep.camp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        final int cars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        final int turns = scanner.nextInt();

        final Race race = Race.of(cars, turns);
        race.processAll();
        System.out.println(race.gameResult());
    }
}
