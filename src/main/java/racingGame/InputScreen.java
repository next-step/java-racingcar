package racingGame;

import java.util.List;
import java.util.Scanner;

public class InputScreen {
    public List<Integer> askInput(Scanner scanner) {


        System.out.println("자동차 대수는 몇 대인가요?");
        validateNegative(scanner);
        int carNum = Integer.parseInt(scanner.next());
        System.out.println("시도할 회수는 몇 회인가요?");
        validateNegative(scanner);
        int tryNum = Integer.parseInt(scanner.next());

        return List.of(carNum, tryNum);
    }

    private static void validateNegative(Scanner scanner) {
        if (Integer.parseInt(scanner.next()) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
