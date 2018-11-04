package racing.ui;

import racing.dto.RacingGameCreateRequest;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    public static RacingGameCreateRequest getRacingGameCreateInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int number = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        return new RacingGameCreateRequest(number, time);
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
