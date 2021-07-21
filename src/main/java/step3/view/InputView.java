package step3.view;

import step3.game.GameDto;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    static public GameDto initGameEnv() {
        Scanner scanner = new Scanner(System.in);

        InputView.viewCarCount();
        int carCount = scanner.nextInt();
        InputView.viewCount();
        int count = scanner.nextInt();

        return GameDto.of(carCount, count);
    }

    static public void viewCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    static public void viewCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }
}
