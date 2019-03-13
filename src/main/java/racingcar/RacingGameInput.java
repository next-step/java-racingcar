package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGameInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> takeCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> carNames = Arrays.asList(scanner.nextLine().split(","));

        return carNames;
    }

    public static int takeNumberOfTimes() {
        System.out.println("시도할 회수는 몇 회 인가요? ");
        return scanner.nextInt();
    }
}
