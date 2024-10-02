package step3RacingCarCompetition;

import java.util.Scanner;

public class InputTryCount {
    public static Integer movingTryCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
