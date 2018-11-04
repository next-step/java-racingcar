package racing.ui;

import racing.dto.RacingCarStatus;
import racing.dto.RacingGameCreateRequest;
import racing.util.RacingCarStringUtils;

import java.util.List;
import java.util.Scanner;

import static racing.util.RacingCarStringUtils.getHyphenStr;

public class ConsoleUI {

    public static RacingGameCreateRequest getRacingGameCreateInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String rawNames = scanner.next();
        List<String> names = RacingCarStringUtils.splitByComma(rawNames);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        return new RacingGameCreateRequest(names, time);
    }

    public static void printRacingCarStatuses(List<RacingCarStatus> racingCarStatuses) {
        racingCarStatuses.forEach(status -> {
            String name = status.getName();
            String hyphenPosition = getHyphenStr(status.getPosition());

            System.out.println(String.format("%s : %s", name, hyphenPosition));
        });

        System.out.println();
    }

    public static void printResultHeader() {
        System.out.println("\n실행결과");
    }
}
