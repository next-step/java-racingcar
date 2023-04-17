package step3.view;

import step3.domain.RaceCondition;

import java.util.Scanner;

public class RaceConditionInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static RaceCondition readRaceCondition() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int raceRound = scanner.nextInt();

        return RaceCondition.create(carCount, raceRound);
    }
}
