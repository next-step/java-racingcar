package racingcar;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        gameStart();
    }

    private static void gameStart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = Integer.parseInt(scanner.nextLine());
        RacingGame racingGame = new RacingGame(carNames, moveCount);
        racingGame.startRace();
    }
}



