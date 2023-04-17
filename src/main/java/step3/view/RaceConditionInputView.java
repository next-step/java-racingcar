package step3.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RaceConditionInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();

        return Arrays.asList(carNames.split(","));
    }

    public static int readRaceRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int raceRound = scanner.nextInt();
        if (raceRound < 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
        return raceRound;
    }
}
