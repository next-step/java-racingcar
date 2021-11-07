package edu.nextstep.camp;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        final int cars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        final int turns = scanner.nextInt();

        final String track = "#".repeat(turns);
        final Race race = Race.of(cars, turns);
        while (!race.isEnded()) {
            race.process();
            System.out.println(track);
            System.out.println(race.printResult().collect(Collectors.joining("\n")));
            System.out.println(track);
        }
    }
}
