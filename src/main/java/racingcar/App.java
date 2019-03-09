package racingcar;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        gameStart();

    }

    private static void gameStart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = Integer.parseInt(scanner.nextLine());
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = Integer.parseInt(scanner.nextLine());

        RacingGame racingGame = new RacingGame(carCount, moveCount);

//        racingGame.setGame(carCount, moveCount);

        racingGame.startRace();
    }
}



