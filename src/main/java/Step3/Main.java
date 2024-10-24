package Step3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int carNum = readInput("자동차 대수는 몇 대 인가요?");
        int playNum = readInput("시도할 횟수는 몇 회 인가요?");

        RacingGame game = new RacingGame();
        game.makeBoard(carNum, playNum);

        game.play();

    }

    private static int readInput(String question) {
        System.out.println(question);

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        return Integer.parseInt(value);
    }
}
