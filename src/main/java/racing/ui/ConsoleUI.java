package racing.ui;

import racing.dto.RacingGameCreateRequest;
import racing.util.StringUtils;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    public static RacingGameCreateRequest getRacingGameCreateInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String rawNames = scanner.next();
        List<String> names = StringUtils.splitByComma(rawNames);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        return new RacingGameCreateRequest(names, time);
    }

    public static void printRacingCarPositions(List<Integer> positions) {
        positions.forEach(i -> {
            String visiblePosition = new String(new char[i]).replace("\0", "-");
            System.out.println(visiblePosition);
        });

        System.out.println();
    }

    public static void printResultHeader() {
        System.out.println("\n실행결과");
    }
}
