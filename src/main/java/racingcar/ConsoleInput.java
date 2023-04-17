package racingcar;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private static final String QUESTION_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_FOR_TOTAL_MOVE_COUNT = "시도할 회수는 몇 회 인가요?";

    @Override
    public Race setRaceAndRetryIfInvalid() {
        Race race;
        while (true) {
            try {
                race = this.setRace();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return race;
    }

    private Race setRace() {
        Scanner scanner = new Scanner(System.in);

        askTotalCarCount();
        String carNamesString = scanner.nextLine();

        askTotalMoveCount();
        Integer totalMoveCount = scanner.nextInt();

        return new Race(carNamesString, totalMoveCount);
    }

    private static void askTotalMoveCount() {
        System.out.println(QUESTION_FOR_TOTAL_MOVE_COUNT);
    }

    private static void askTotalCarCount() {
        System.out.println(QUESTION_FOR_CAR_NAMES);
    }
}
