package racing;

import java.util.Map;
import java.util.Scanner;

public class RacingMain {

    private RacingMain() {

    }

    public static void main(String[] args) {
        racingGame();
    }

    public static Map<Integer, Integer> racingGame() {
        Scanner scanner = new Scanner(System.in);
        int carCount = scan(scanner, "자동차 대수는 몇 대 인가요?");
        int moveCount = scan(scanner, "시도할 회수는 몇 회 인가요?");

        return Racing.racing(carCount, moveCount);
    }

    private static int scan(Scanner scanner, String inputText) {
        System.out.println(inputText);
        return scanner.nextInt();
    }
}