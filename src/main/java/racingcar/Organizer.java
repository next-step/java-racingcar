package racingcar;

import java.util.Scanner;

public class Organizer {

    private static final String ASK_CAR_MENT = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_ROUND_MENT = "시도할 회수는 몇 회 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game(askCar(), askRound());
        game.play();
    }

    public static int askCar() {
        System.out.println(ASK_CAR_MENT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int askRound() {
        System.out.println(ASK_ROUND_MENT);
        return Integer.parseInt(scanner.nextLine());
    }


}
